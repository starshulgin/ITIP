public class Main {
    public static void main(String[] args) {
        CarHashTable carTable = new CarHashTable();
        
        carTable.put("А123ВС77", new Car("Toyota", "Camry", 2020));
        carTable.put("В456ОР77", new Car("Honda", "Civic", 2019));
        carTable.put("С789ТХ77", new Car("BMW", "M4", 2021));
        
        Car car1 = carTable.get("А123ВС77");
        System.out.println("Найден: " + car1.getBrand() + " " + car1.getModel());
        
        Car removedCar = carTable.remove("В456ОР77");
        System.out.println("Удален: " + removedCar.getBrand() + " " + removedCar.getModel());
        
        System.out.println("Количество автомобилей: " + carTable.size());
        System.out.println("Таблица пуста: " + carTable.isEmpty());
    }
}