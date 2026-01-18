package lab4;
import java.io.*;

public class FileCopyV1 {
    public static void main(String[] args) {
        FileInputStream sourceFile = null;
        FileOutputStream destinationFile = null;
        
        try {
            sourceFile = new FileInputStream("text.txt");
            destinationFile = new FileOutputStream("newtext.txt");
            
            int byteData;
            while ((byteData = sourceFile.read()) != -1) {//до конца файла
                destinationFile.write(byteData);
            }
            
            System.out.println("Файл успешно скопирован!");
            
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            try {
                if (sourceFile != null) sourceFile.close();//закрыть поток чтения
                if (destinationFile != null) destinationFile.close();//записи
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла: " + e.getMessage());
            }
        }
    }
}