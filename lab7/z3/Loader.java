package lab7.z3;

import java.util.Random;

public class Loader extends Thread {
    private final Warehouse warehouse;
    private int totalWeightCarried = 0;
    private static final Random random = new Random();
    
    public Loader(String name, Warehouse warehouse) {
        super(name);
        this.warehouse = warehouse;
    }
    
    @Override
    public void run() {
        System.out.println(getName() + " начал работу");
        
        while (!warehouse.isEmpty()) {
            while (!warehouse.isShipmentReady() && !warehouse.isEmpty()) {
                Product product = warehouse.takeProduct(getName());
                
                if (product != null) {
                    totalWeightCarried += product.getWeight();
                    try {
                        Thread.sleep(200 + random.nextInt(300));
                    } catch (InterruptedException e) {
                        System.out.println(getName() + " был прерван");
                        return;
                    }
                }
            }
            
            if (warehouse.isShipmentReady()) {
                System.out.println(getName() + " участвует в отправке");
                warehouse.shipProducts();
                
                try {
                    Thread.sleep(800 + random.nextInt(400));
                } catch (InterruptedException e) {
                    System.out.println(getName() + " был прерван");
                    return;
                }
            }
        }
        
        System.out.println(getName() + " завершил. Перенес: " + totalWeightCarried + "кг");
    }
    
    public int getTotalWeightCarried() {
        return totalWeightCarried;
    }
}
