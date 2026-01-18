package lab6;
import java.util.*;

public class StoreSales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> soldProducts = new ArrayList<>();
        
        while (true) {
            System.out.println("\n1. Добавить проданный товар");
            System.out.println("2. Показать все товары");
            System.out.println("3. Статистика");
            System.out.println("4. Выход");
            System.out.print("Выберите: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Введите товар: ");
                    String product = scanner.nextLine();
                    soldProducts.add(product);
                    System.out.println("Товар добавлен!");
                    break;
                    
                case 2:
                    if (soldProducts.isEmpty()) {
                        System.out.println("Товаров нет");
                    } else {
                        System.out.println("Все товары:");
                        for (int i = 0; i < soldProducts.size(); i++) {
                            System.out.println((i + 1) + ". " + soldProducts.get(i));
                        }
                    }
                    break;
                    
                case 3:
                    if (soldProducts.isEmpty()) {
                        System.out.println("Товаров нет");
                    } else {
                        // Общее количество
                        System.out.println("Всего продаж: " + soldProducts.size());
                        
                        // Находим самый популярный товар
                        Map<String, Integer> countMap = new HashMap<>();
                        for (String item : soldProducts) {
                            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
                        }
                        
                        String mostPopular = "";
                        int maxCount = 0;
                        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                            if (entry.getValue() > maxCount) {
                                maxCount = entry.getValue();
                                mostPopular = entry.getKey();
                            }
                        }
                        
                        System.out.println("самый популярный: " + mostPopular + " (" + maxCount + " раз)");
                    }
                    break;
                    
                case 4:
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("неверный выбор");
            }
        }
    }
}