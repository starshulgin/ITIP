package lab7.z3;

import java.util.*;
public class Warehouse {
    private final Queue<Product> products = new LinkedList<>();
    private int currentWeight = 0;
    private final int MAX_WEIGHT = 150;
    private boolean shipmentReady = false;
    
    public synchronized void addProduct(Product product) {
        products.add(product);
    }
    
    public synchronized Product takeProduct(String loaderName) {
        if (products.isEmpty() || shipmentReady) {
            return null;
        }
        
        Product product = products.poll();
        if (product != null) {
            currentWeight += product.getWeight();
            System.out.println(loaderName + " взял " + product + 
                             " вес: " + currentWeight + "кг");
            
            if (currentWeight >= MAX_WEIGHT) {
                shipmentReady = true;
                System.out.println("\n>>> Достигнут лимит " + MAX_WEIGHT + 
                                 "кг! Готовим отправку <<<");
            }
        }
        
        return product;
    }
    
    public synchronized void shipProducts() {
        if (shipmentReady) {
            System.out.println("--- отправка на другой склад ---");
            System.out.println("--- разгрузка товаров ---");
            currentWeight = 0;
            shipmentReady = false;
            System.out.println("--- готов к партии ---\n");
        }
    }
    
    public synchronized boolean isShipmentReady() {
        return shipmentReady;
    }
    
    public synchronized boolean isEmpty() {
        return products.isEmpty();
    }
    
    public synchronized int getProductsCount() {
        return products.size();
    }
}