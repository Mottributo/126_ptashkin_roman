package task;

public abstract class BattleUnitBase implements BattleUnit {

    // Fields
    private int health;
    private int armor;
    private int strength;
    private String name;
    private int maxHealth;
    private int baseStrength;
    private int maxArmor;
    private int minHealth = 0;
    private int minArmor = 0;


    // Constructor
    public BattleUnitBase(String name, int maxHealth, int baseStrength, int maxArmor) {
        this.name = name;
        this.maxArmor = maxArmor;
        this.armor = this.maxArmor;
        this.baseStrength = baseStrength;
        this.strength = this.baseStrength;
        this.maxHealth = maxHealth;
        this.health = this.maxHealth;
    }


    // Methods
    public String name() {return name;}
    public int health() {return health;}
    public int strength() {return strength;}
    public int baseStrength() {return baseStrength;}
    public int armor() {return armor;}

    public int maxHealth() {return maxHealth;}
    public int maxArmor() {return maxArmor;}

    public void setMaxHealth(int value) {
        maxHealth = value;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    public void setStrength(int value) {
        strength = value;
    }
    public void setMaxArmor(int value) {
        maxArmor = value;
        if (armor > maxArmor){
            armor = maxArmor;
        }
    }

    public void heal(int value) {
        health += value;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
    public void takeDamage(int value) {
        if (value < 1) value = 1;
        health -= value;
        if (health < minHealth) {
            health = minHealth;
        }
    }
    public void restoreArmor(int value) {
        armor += value;
        if (armor > maxArmor) {
            armor = maxArmor;
        }
    }
    public void damageArmor(int value) {
        if (value < 1) value = 1;
        armor -= value;
        if (armor < minArmor) {
            armor = minArmor;
        }
    }


    // Abstract Methods
    public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);
    public abstract void attack(BattleUnit other);
}
