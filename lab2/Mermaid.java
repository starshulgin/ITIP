package lab2;

class Mermaid extends Monster {
    private String song;
    private int charm;

    public Mermaid() {
        super("Русалка", 100, 3);
        this.song = "Песня сирены";
        this.charm = 70;
    }

    public Mermaid(String name, int health, int level, String song, int charm) {
        super(name, health, level);
        this.song = song;
        this.charm = charm;
    }

    @Override
    public void attack() {
        System.out.println("Русалка атакует с помощью " + song);
    }

    @Override
    public void specialAbility() {
        System.out.println("Русалка очаровывает с силой: " + charm);
    }
    
    public String getSong() { return song; }
    public void setSong(String song) { this.song = song; }
    
    public int getCharm() { return charm; }
    public void setCharm(int charm) { this.charm = charm; }
}