package lab2;

class Dragon extends Monster {
    private String element;
    private int firePower;

    public Dragon() {
        super("Дракон", 150, 5);
        this.element = "Огонь";
        this.firePower = 85;
    }

    public Dragon(String name, int health, int level, String element, int firePower) {
        super(name, health, level);
        this.element = element;
        this.firePower = firePower;
    }

    @Override
    public void attack() {
        System.out.println("Дракон атакует с помощью " + element);
    }

    @Override
    public void specialAbility() {
        System.out.println("Дракон использует огонь с силой: " + firePower);
    }
    
    public String getElement() { return element; }
    public void setElement(String element) { this.element = element; }
    
    public int getFirePower() { return firePower; }
    public void setFirePower(int firePower) { this.firePower = firePower; }
}