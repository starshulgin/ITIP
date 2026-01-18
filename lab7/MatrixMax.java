package lab7;

import java.util.Random;

public class MatrixMax {

    private static class RowMaxFinder extends Thread {
        private final int[] row;
        private int maxInRow;
        
        public RowMaxFinder(int[] row) {
            this.row = row;
            this.maxInRow = Integer.MIN_VALUE;
        }
        
        @Override
        public void run() {
            for (int num : row) {
                if (num > maxInRow) {
                    maxInRow = num;
                }
            }
        }
        
        public int getMaxInRow() {
            return maxInRow;
        }
    }
    
    public static void main(String[] args) {
        int rows = 10;
        int cols = 10;
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(1000);
            }
        }
        
        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
        
        RowMaxFinder[] threads = new RowMaxFinder[rows];
        
        for (int i = 0; i < rows; i++) {
            threads[i] = new RowMaxFinder(matrix[i]);
            threads[i].start();
        }
        
        try {
            for (RowMaxFinder thread : threads) {
                thread.join();
            }
            
            int globalMax = Integer.MIN_VALUE;
            for (RowMaxFinder thread : threads) {
                int rowMax = thread.getMaxInRow();
                if (rowMax > globalMax) {
                    globalMax = rowMax;
                }
            }
            
            int directMax = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] > directMax) {
                        directMax = matrix[i][j];
                    }
                }
            }
            
            System.out.println("\nМаксимальный элемент через потоки: " + globalMax);
            System.out.println("Прямой поиск максимума: " + directMax);
            System.out.println("Результаты совпадают: " + (globalMax == directMax));
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
