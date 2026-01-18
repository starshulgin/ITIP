package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "text.txt";
        File file = new File(filePath);
        
        if (!file.exists()) {
            System.out.println("Файл не найден!");
            return;
        }
        
        Scanner scanner = new Scanner(file);
        
        Map<String, Integer> wordMap = new HashMap<>();
        
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");
            
            if (word.length() > 0) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }
        
        scanner.close();
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordMap.entrySet());
        
        list.sort((a, b) -> b.getValue() - a.getValue());
        
        System.out.println("Топ-10 самых часто встречающихся слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
        }
    }
}