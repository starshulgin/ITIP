import java.util.LinkedList;

public class CarHashTable {
    private LinkedList<CarEntry>[] table;
    private int size;

    public CarHashTable() {
        table = new LinkedList[16];
        size = 0;
    }

    private static class CarEntry {
        String licensePlate;
        Car car;

        CarEntry(String licensePlate, Car car) {
            this.licensePlate = licensePlate;
            this.car = car;
        }
    }

    private int hash(String licensePlate) {
        return Math.abs(licensePlate.hashCode()) % table.length;
    }

    public void put(String licensePlate, Car car) {
        int index = hash(licensePlate);
        
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        
        for (CarEntry entry : table[index]) {
            if (entry.licensePlate.equals(licensePlate)) {
                entry.car = car;
                return;
            }
        }
        
        table[index].add(new CarEntry(licensePlate, car));
        size++;
    }

    public Car get(String licensePlate) {
        int index = hash(licensePlate);
        
        if (table[index] == null) {
            return null;
        }
        
        for (CarEntry entry : table[index]) {
            if (entry.licensePlate.equals(licensePlate)) {
                return entry.car;
            }
        }
        
        return null;
    }

    public Car remove(String licensePlate) {
        int index = hash(licensePlate);
        
        if (table[index] == null) {
            return null;
        }
        
        for (CarEntry entry : table[index]) {
            if (entry.licensePlate.equals(licensePlate)) {
                Car removedCar = entry.car;
                table[index].remove(entry);
                size--;
                return removedCar;
            }
        }
        
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}