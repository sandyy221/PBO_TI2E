package Game;

public class Monster extends Enemy {
    private String type;

    public Monster(String name, int health, int attackPower, int threatLevel, String type) {
    super(name, health, attackPower, threatLevel);
    this.type = type;
    this.attackStrategy = new FixedStrategy();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void attack(Character target) {
        int bonus = (int) (Math.random() * 6);
        int damage = getAttackPower() + bonus;

        System.out.println(getName() + " (" + type + ") menyerang " + target.getName() +
                " dengan kekuatan: " + damage);
        target.takeDamage(damage);
    }
}