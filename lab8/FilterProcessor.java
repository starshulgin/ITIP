package lab8;
import java.util.*;
import java.util.stream.*;

public class FilterProcessor {
    @DataProcessor
    public List<String> filterByPrice(List<String> data) {
        return data.stream()//поток
            .filter(line -> {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    int price = Integer.parseInt(parts[1].trim());
                    return price > 50;
                }
                return false;
            })
            .collect(Collectors.toList()); 
            //фильтр по частям оставляем только >50
    }
    
    @DataProcessor
    public List<String> filterByCategory(List<String> data) {
        return data.stream()
            .filter(line -> line.contains("фрукт"))
            .collect(Collectors.toList());//содержит ли фрукт
    }
}
