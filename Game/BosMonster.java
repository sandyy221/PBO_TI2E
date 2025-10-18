package Game;

public class BosMonster extends Enemy {
    private String type;
    private int turnCounter = 0;

    public BosMonster(String name, int health, int attackPower, int threatLevel, String type) {
    super(name, health, attackPower, threatLevel);
    this.type = type;
    this.attackStrategy = new LevelScaledStrategy();
    }

    public String getType() {
        return type;
    }

    @Override
    public void attack(Character target) {
        turnCounter++;

        boolean rageStrike = (getHealth() < 50) || (turnCounter % 3 == 0);
        int damage;

        if (rageStrike) {
            damage = getAttackPower() * 2;
            System.out.println( getName() + " (" + type + ") menggunakan Rage Strike! Damage: " + damage);
        } else {
            damage = getAttackPower();
            System.out.println(getName() + " (" + type + ") menyerang biasa. Damage: " + damage);
        }

        target.takeDamage(damage);
    }
}