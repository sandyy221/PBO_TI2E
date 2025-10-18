package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends Character {
    private int level;
    private final List<Skill> skills = new ArrayList<>();
    private final Random rand = new Random();

    public Player(String name, int health, int attackPower, int level) {
        super(name, health, attackPower);
        this.level = level;
        this.attackStrategy = new LevelScaledStrategy();
    }

    public int getLevel() {
        return level;
    }

    public void addSkill(Skill skill) {
        if (skill != null) skills.add(skill);
    }
     public void heal() {
        int healAmount = 20;
        setHealth(Math.min(getHealth() + healAmount, 100)); 
        System.out.println(getName() + " heals +" + healAmount + " HP! kondisi kesehatan: " + getHealth());
    }
    @Override
    public void attack(Character target) {
        if (skills.isEmpty()) {
            int damage = attackStrategy.calculateDamage(this, target);
            System.out.println(getName() + " menyerang dengan " +
                    attackStrategy.getName() + "! Damage: " + damage);
            target.takeDamage(damage);
            return;
        }

        Skill chosen = skills.get(rand.nextInt(skills.size()));
        System.out.println(getName() + " memilih skill: " + chosen.name());
        chosen.apply(this, target);
    }
}
