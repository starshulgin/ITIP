package lab7.z3;

import java.util.Random;

public class WarehouseSimulation {
    public static void main(String[] args) throws InterruptedException {
        Warehouse warehouse = new Warehouse();
        Random random = new Random();
        
        String[] productNames = {
            "Холодильник", "Стиральная машина", "Телевизор", 
            "Микроволновка", "Пылесос", "Утюг", "Чайник", "Стул"
        };
        
        int totalProducts = 20;
        
        System.out.println("=== ИНИЦИАЛИЗАЦИЯ СКЛАДА ===\n");
        System.out.println("Добавляем " + totalProducts + " товаров:");
        
        for (int i = 1; i <= totalProducts; i++) {
            String name = productNames[random.nextInt(productNames.length)] + i;
            int weight = 10 + random.nextInt(41);
            Product product = new Product(name, weight);
            warehouse.addProduct(product);
            
            if (i <= 5) {
                System.out.println("  " + product);
            }
        }
        
        if (totalProducts > 5) {
            System.out.println("... и еще " + (totalProducts - 5) + " товаров");
        }
        
        System.out.println("\n=== начало работы ===");
        
        Loader loader1 = new Loader("Грузчик 1", warehouse);
        Loader loader2 = new Loader("Грузчик 2", warehouse);
        Loader loader3 = new Loader("Грузчик 3", warehouse);
        
        loader1.start();
        loader2.start();
        loader3.start();
        
        loader1.join();
        loader2.join();
        loader3.join();
        
        System.out.println("\n=== итого ===");
        System.out.println("Грузчик 1 перенес: " + loader1.getTotalWeightCarried() + "кг");
        System.out.println("Грузчик 2 перенес: " + loader2.getTotalWeightCarried() + "кг");
        System.out.println("Грузчик 3 перенес: " + loader3.getTotalWeightCarried() + "кг");
        
        int totalCarried = loader1.getTotalWeightCarried() + 
                          loader2.getTotalWeightCarried() + 
                          loader3.getTotalWeightCarried();
        
        System.out.println("Общий вес: " + totalCarried + "кг");
        System.out.println("\nВсе товары перенесены!");
    }
}