package Game;

public interface AttackStrategy {
    int calculateDamage(Character attacker, Character target);
    String getName();
}
