package Game;

public class FixedStrategy implements AttackStrategy {

    @Override
    public int calculateDamage(Character attacker, Character target) {
        return attacker.getAttackPower();
    }

    @Override
    public String getName() {
        return "Fixed Damage";
    }
}