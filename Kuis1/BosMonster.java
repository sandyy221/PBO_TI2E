package Kuis1;

public class BosMonster extends Monster {
    public BosMonster(String name, int health, int attackPower, String type) {
        super(name, health, attackPower, type);
    }
    public void attack(Character target) {
        int damage = ((int)(Math.random() * 10) + 5) * 2;
        System.out.println(getName() + " Boss " + getType() + 
        " melancarkan serangan! damage ditreima: " + damage);
        target.takeDamage(damage);
    }
}