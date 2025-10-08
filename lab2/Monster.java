package lab2;

abstract class Monster {
    private String name;
    private int health;
    private int level;
    private static int count = 0;

    public Monster() {
        count++;
    }

    public Monster(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
        count++;
    }

    public abstract void attack();
    public abstract void specialAbility();
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    
    public static int getCount() { return count; }

    public void displayInfo() {
        System.out.println(name + " - Здоровье: " + health + ", Уровень: " + level);
    }
}