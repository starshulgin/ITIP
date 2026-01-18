package lab8;
public class MainApp {
    public static void main(String[] args) {
        DataManager manager = new DataManager();
        
        manager.registerDataProcessor(new FilterProcessor());
        manager.registerDataProcessor(new TransformProcessor());
        manager.registerDataProcessor(new AggregateProcessor());
        
        manager.loadData("data.txt");
        
        manager.processData();
        
        manager.saveData("result.txt");
        
        manager.shutdown();
        
        System.out.println("Готово!");
    }
}