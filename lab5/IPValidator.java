package lab5;
import java.util.regex.*;
import java.util.Scanner;

public class IPValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Введите IP-адрес: ");
            String ipAddress = scanner.nextLine();
            
            Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
            Matcher matcher = pattern.matcher(ipAddress);
            
            if (matcher.matches()) {
                System.out.println("IP-адрес корректен!");
            } else {
                System.out.println("IP-адрес некорректен!");
                System.out.println("IP-адрес должен состоять из 4 чисел (0-255), разделенных точками.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}