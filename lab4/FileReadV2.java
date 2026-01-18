package lab4;
import java.io.*;

public class FileReadV2 {
    public static void main(String[] args) {//после трай все закроется
        try (FileInputStream sourceFile = new FileInputStream("test.txt");
             FileOutputStream destinationFile = new FileOutputStream("destination.txt")) {
            
            byte[] buffer = new byte[1024]; //буфер для чтения
            int bytesRead;
            
            while ((bytesRead = sourceFile.read(buffer)) != -1) {
                destinationFile.write(buffer, 0, bytesRead);
            }
            
            System.out.println("Файл успешно скопирован!");
            
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
            e.printStackTrace();
        }
    }
}