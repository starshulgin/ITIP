package lab2;
import java.util.Scanner;

public class MonsterLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Goblin goblin = new Goblin();
        Mermaid mermaid = new Mermaid();
        Dragon dragon = new Dragon();

        System.out.println(" Лабораторная работа: Монстры ");
        System.out.println("Создано монстров: " + Monster.getCount());
        System.out.println();
        
        Monster[] monsters = {goblin, mermaid, dragon};
        for (Monster m : monsters) {
            m.displayInfo();
            m.attack();
            m.specialAbility();
            System.out.println();
        }

        System.out.println(" Информация ");
        System.out.println("Гоблин:");
        System.out.println("Оружие: " + goblin.getWeapon());
        System.out.println("Скрытность: " + goblin.getStealth());
        
        System.out.println("\nРусалка:");
        System.out.println("Песня: " + mermaid.getSong());
        System.out.println("Очарование: " + mermaid.getCharm());
        
        System.out.println("\nДракон:");
        System.out.println("Элемент: " + dragon.getElement());
        System.out.println("Сила огня: " + dragon.getFirePower());

        scanner.close();
    }
}