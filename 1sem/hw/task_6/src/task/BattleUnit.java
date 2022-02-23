package task;

public class BattleUnit {

    // Fields
    private int strength;
    private int armor;
    private int health;
    private int x;
    private int y;


    // Constructors
    public BattleUnit(int strength, int armor, int health, int x, int y) {
        this.strength = strength;
        this.armor = armor;
        this.health = health;
        this.x = x;
        this.y = y;
    }


    // Methods
    public int getArmor() {return armor;}
    public int getHealth() {return health;}
    public int getStrength() {return strength;}
    public int getX() {return x;}
    public int getY() {return y;}

    public void moveUp() {this.y--;}
    public void moveDown() {this.y++;}
    public void moveLeft() {this.x--;}
    public void moveRight() {this.x++;}

    public void attacked(BattleUnit enemy) {
        this.health -= Math.min(enemy.getStrength(), Math.max(0, enemy.getStrength() - this.getArmor()));
    }
    public boolean isAlive() {
        return this.health > 0;
    }
}
