package Game;

public class LevelScaledStrategy implements AttackStrategy {

    @Override
    public int calculateDamage(Character attacker, Character target) {
        int base = attacker.getAttackPower();
        int bonus = 0;

        if (attacker instanceof Player p) {
            bonus = p.getLevel() * 2;
        }

        return base + bonus;
    }

    @Override
    public String getName() {
        return "Level-Scaled Damage";
    }
}