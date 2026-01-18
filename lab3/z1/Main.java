public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>();
        //рандомтест
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 3);
        
        System.out.println(table.get("two"));
        System.out.println(table.size()); 
        System.out.println(table.isEmpty());
        
        table.remove("two");
        System.out.println(table.get("two"));
        System.out.println(table.size());
    }
}