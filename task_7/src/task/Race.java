package task;

import javax.lang.model.util.ElementFilter;

public enum Race {

    // Entries
    Orc(6, 12, 2),
    Elf(2, 9, 9),
    Dwarf(6, 10, 4),
    Halfling(1, 8, 11),
    Human(6, 7, 7);

    // Fields
    private int strength, health, dexterity;

    // Constructors
    Race(int strength, int health, int dexterity) {
        this.strength = strength;
        this.health = health;
        this.dexterity = dexterity;
    }

    // Methods
    public int strength() {return strength;}
    public int health() {return health;}
    public int dexterity() {return dexterity;}
}
