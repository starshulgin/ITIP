package lab4.z3;

class CustomAgeException extends Exception {
    public CustomAgeException(String message) {
        super(message);
    }
}
//ловим свое же искл
public class AgeValidator {
    public static void main(String[] args) {
        try {
            checkAge(150);
        } catch (CustomAgeException e) {
            System.out.println("ошибка: " + e.getMessage());
            ExceptionLogger.logException(e); //в логгер
        }
    }
    
    public static void checkAge(int age) throws CustomAgeException {//метод с условиями выброса искл
        if (age < 0 || age > 120) {
            throw new CustomAgeException("возраст " + age + " некорректен");
        }
        System.out.println("возраст " + age + " корректен");
    }
}