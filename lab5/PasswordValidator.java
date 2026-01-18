package lab5;
import java.util.regex.*;
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);
            
            if (matcher.matches()) {
                System.out.println("Пароль корректен!");
            } else {
                System.out.println("Пароль не соответствует требованиям!");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}