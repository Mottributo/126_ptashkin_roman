package task;

public class ArmorDestroyer extends BattleUnitBase {

    public ArmorDestroyer(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }

    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        int maxIndex = 0;
        int maxArmor = Integer.MIN_VALUE;
        for (int i = 0; i < enemyTeam.length; i++) {
            if (enemyTeam[i].armor() > maxArmor && enemyTeam[i].health() > 0) {
                maxIndex = i;
                maxArmor = enemyTeam[i].armor();
            }
        }
        if (enemyTeam[maxIndex].armor() > 0) {
            enemyTeam[maxIndex].damageArmor(strength() * 2);
        }
        else if (strength() > 4) enemyTeam[maxIndex].takeDamage(strength() / 4);
        else enemyTeam[maxIndex].takeDamage(1);
    }

    @Override
    public void attack(BattleUnit other) {
        if (other.armor() > 0) {
            if (strength() > 4) other.takeDamage(strength() / 4);
            else other.takeDamage(1);

            if (strength() < 1) other.damageArmor(1);
            else other.damageArmor(strength());
        }
        else {
            if (strength() < 1) other.takeDamage(1);
            else other.takeDamage(strength() / 2);
        }
    }
}
