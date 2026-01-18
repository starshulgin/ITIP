package lab4.z3;
import java.util.logging.*;
//запись сообщения об ошибке в лог
public class ExceptionLogger {
    public static void logException(Exception e) {
        try {
            Logger logger = Logger.getLogger("MyLogger");
            FileHandler fh = new FileHandler("exceptions.log", true);
            logger.addHandler(fh);
            logger.severe(e.getMessage());
            fh.close();
        } catch (Exception ex) {
            System.out.println("Не удалось записать в лог: " + ex.getMessage());
        }
    }
}