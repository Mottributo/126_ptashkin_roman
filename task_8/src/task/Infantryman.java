package task;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Infantryman extends BattleUnitBase {

    public Infantryman(String name, int maxHealth, int baseStrength, int maxArmor) {
        super(name, maxHealth, baseStrength, maxArmor);
    }

    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam) {
        // None. Gun-meat, after all.
    }

    @Override
    public void attack(BattleUnit other) {
        if (other.armor() > 0) {
            other.takeDamage(strength() / 2);
            other.damageArmor(strength() / 4);
        }
        else {
            other.takeDamage(strength());
        }
    }
}
