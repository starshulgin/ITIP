package lab2;

class Goblin extends Monster {
    private String weapon;
    private int stealth;

    public Goblin() {
        super("Гоблин", 80, 2);
        this.weapon = "Нож";
        this.stealth = 60;
    }

    public Goblin(String name, int health, int level, String weapon, int stealth) {
        super(name, health, level);
        this.weapon = weapon;
        this.stealth = stealth;
    }

    @Override
    public void attack() {
        System.out.println("Гоблин атакует с помощью " + weapon);
    }

    @Override
    public void specialAbility() {
        System.out.println("Гоблин использует скрытность: " + stealth);
    }
    
    public String getWeapon() { return weapon; }
    public void setWeapon(String weapon) { this.weapon = weapon; }
    
    public int getStealth() { return stealth; }
    public void setStealth(int stealth) { this.stealth = stealth; }
}