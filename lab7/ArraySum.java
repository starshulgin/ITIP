package lab7;

import java.util.Random;

public class ArraySum {

    private static class SumCalculator extends Thread {
        private final int[] array;
        private final int start;
        private final int end;
        private long partialSum;
        
        public SumCalculator(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.partialSum = 0;
        }
        
        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
        }
        
        public long getPartialSum() {
            return partialSum;
        }
    }
    
    public static void main(String[] args) {
        int size = 1000000;
        int[] array = new int[size];
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        
        int mid = size / 2;
        SumCalculator thread1 = new SumCalculator(array, 0, mid);
        SumCalculator thread2 = new SumCalculator(array, mid, size);
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
            
            long totalSum = thread1.getPartialSum() + thread2.getPartialSum();
            
            long directSum = 0;
            for (int num : array) {
                directSum += num;
            }
            
            System.out.println("Сумма через потоки: " + totalSum);
            System.out.println("Прямая сумма: " + directSum);
            System.out.println("Результаты совпадают: " + (totalSum == directSum));
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
