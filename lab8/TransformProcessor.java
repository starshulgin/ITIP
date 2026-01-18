package lab8;
import java.util.*;
import java.util.stream.*;

public class TransformProcessor {
    @DataProcessor
    public List<String> addDiscount(List<String> data) {
        return data.stream()
            .map(line -> { //фильтр не меняет, мап каждый меняет
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    int price = Integer.parseInt(parts[1].trim());
                    int newPrice = (int)(price * 0.9);
                    return parts[0] + "," + newPrice + "," + parts[2];
                }
                return line;
            })
            .collect(Collectors.toList());
    }
    
    @DataProcessor
    public List<String> addTax(List<String> data) {
        return data.stream()
            .map(line -> {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    int price = Integer.parseInt(parts[1].trim());
                    int newPrice = (int)(price * 1.2);
                    return parts[0] + "," + newPrice + "," + parts[2];
                }
                return line;
            })
            .collect(Collectors.toList());
    }
}