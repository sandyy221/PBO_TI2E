package Kuis1;

class Monster extends Character {
    private String type;

    public Monster(String name, int health, int attackPower, String type) {
        super(name, health, attackPower);
        this.type = type;
    }

    @Override
    public void attack(Character target) {
        int damage = (int) (Math.random() * 10) + 5;
        System.out.println(getName() + " (" + type + ") attacks ferociously! Damage: " +
                damage);
        target.takeDamage(damage);
    }
}