package lab8;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class DataManager {
    private List<Object> processors = new ArrayList<>();
    private List<String> data = Collections.synchronizedList(new ArrayList<>());
    private List<String> result = Collections.synchronizedList(new ArrayList<>());
    private ExecutorService executor;
    
    public DataManager() {
        executor = Executors.newCachedThreadPool();
    }
    
    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }
    
    public void loadData(String source) {
        System.out.println("Загрузка из: " + source);
        data = Arrays.asList(
            "Яблоко,100,фрукт",
            "Банан,90,фрукт",
            "Морковь,35,овощ",
            "Картофель,80,овощ",
            "Груша,85,фрукт",
            "Огурец,15,овощ"
        );
        System.out.println("Загружено строк: " + data.size());
    }
    
    public void processData() {
        System.out.println("Обработка данных...");
        

        List<CompletableFuture<Void>> futures = processors.stream() //список для кажд процессора
            .map(processor -> CompletableFuture.runAsync(() -> {

                Arrays.stream(processor.getClass().getMethods()) //ток методы с датапроц
                    .filter(m -> m.isAnnotationPresent(DataProcessor.class))
                    .forEach(method -> {
                        try {
                            List<String> processed = (List<String>) method.invoke(processor, data);
                            result.addAll(processed);
                            System.out.println("Обработчик " + method.getName() + " добавил " + processed.size() + " строк");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            }, executor))
            .collect(Collectors.toList());
        
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        
        System.out.println("Итоговых строк: " + result.size());
    }
    
    public void saveData(String destination) {
        System.out.println("Сохранение в: " + destination);
        result.forEach(System.out::println);
        System.out.println("Сохранено строк: " + result.size());
    }
    
    public void shutdown() { //выкл пул потоков
        executor.shutdown();
    }
}