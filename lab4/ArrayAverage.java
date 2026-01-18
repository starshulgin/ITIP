package lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        Object[] arr = {1, 2, "три", 4, 5};
        int sum = 0;
        
        try {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] instanceof Integer) {//проверка на целое
                    sum += (Integer) arr[i];
                } else {
                    throw new NumberFormatException("Элемент массива не является числом: " + arr[i]);
                }
            }
            double average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат числа: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}