package lab8;
import java.util.*;
import java.util.stream.*;

public class AggregateProcessor {
    @DataProcessor
    public List<String> calculateAveragePrice(List<String> data) {
        double avgPrice = data.stream()
            .mapToInt(line -> {//поток целых чисел каждая строка в число выше
                String[] parts = line.split(",");
                return parts.length >= 2 ? Integer.parseInt(parts[1].trim()) : 0;
            })
            .average()
            .orElse(0.0);//если авер пустое
        
        return List.of("Средняя цена: " + avgPrice);
    }
    
    @DataProcessor
    public List<String> countByCategory(List<String> data) {
        Map<String, Long> counts = data.stream()
            .collect(Collectors.groupingBy(
                line -> {
                    String[] parts = line.split(",");
                    return parts.length >= 3 ? parts[2].trim() : "неизвестно";//выбор категории как ключа
                },
                Collectors.counting()//ключ категория значение количество
            ));
        
        List<String> result = new ArrayList<>();
        result.add("Количество по категориям:");
        counts.forEach((cat, count) -> result.add(cat + ": " + count));
        return result;
    }
}