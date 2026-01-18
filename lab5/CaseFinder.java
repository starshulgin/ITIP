package lab5;
import java.util.regex.*;

public class CaseFinder {
    public static void main(String[] args) {
        try {
            String text = "helloWorld thisIsTest javaProgramming";
            
            Pattern pattern = Pattern.compile("[a-z][A-Z]");
            Matcher matcher = pattern.matcher(text);
            
            String result = text;
            
            while (matcher.find()) {
                String match = matcher.group();
                String replacement = "«" + match.charAt(0) + "i" + match.charAt(1) + "»";
                result = result.replace(match, replacement);
            }
            
            System.out.println("Исходный текст: " + text);
            System.out.println("Обработанный текст: " + result);
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}