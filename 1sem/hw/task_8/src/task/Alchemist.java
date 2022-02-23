package task;

public class Alchemist extends BattleUnitBase {
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }

    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        int maxIndex = 0;
        int minHealth = Integer.MAX_VALUE;
        for (int i = 0; i < ownTeam.length; i++) {
            if (ownTeam[i].health() < minHealth && ownTeam[i].health() > 0) {
                maxIndex = i;
                minHealth = ownTeam[i].health();
            }
        }
        int maxIndex1 = 0;
        int maxHealth = Integer.MIN_VALUE;
        for (int i = 0; i < ownTeam.length; i++) {
            if (ownTeam[i].health() > maxHealth && ownTeam[i].health() > 0) {
                maxIndex1 = i;
                maxHealth = ownTeam[i].health();
            }
        }
        ownTeam[maxIndex].heal(10);
        ownTeam[maxIndex1].setStrength(ownTeam[maxIndex1].strength() + 1);
    }

    @Override
    public void attack(BattleUnit other) {
        other.setStrength(other.strength() - 2);
        other.setMaxHealth(other.maxHealth() - 4);
    }
}
