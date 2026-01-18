package lab5;
import java.util.regex.*;
import java.util.Scanner;

public class WordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            String text = "Java is a powerful programming language. JavaScript is also popular.";
            
            System.out.print("Введите букву для поиска: ");
            String letter = scanner.nextLine();
            
            if (letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
                System.out.println("Пожалуйста, введите одну букву!");
                return;
            }
            
            Pattern pattern = Pattern.compile("\\b" + letter + "[a-zA-Z]*\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            
            System.out.println("Слова, начинающиеся с буквы '" + letter + "':");
            boolean found = false;
            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }
            
            if (!found) {
                System.out.println("Слова, начинающиеся с буквы '" + letter + "', не найдены.");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}