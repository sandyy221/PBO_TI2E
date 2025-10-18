package Game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Character {
    private final String name;
    private int health;
    private int attackPower;

    private final List<StatusEffect> effects = new ArrayList<>();

    public void addEffect(StatusEffect effect) {
        if (effect != null) {
            effects.add(effect);
            System.out.println(getName() + " mendapatkan efek baru: " + effect.getClass().getSimpleName());
        }
    }

    public void applyIncomingDamage(int damage) {
        int finalDamage = damage;
        for (StatusEffect e : effects) {
            if (e instanceof Shield) {
                finalDamage = ((Shield) e).reduceDamage(finalDamage);
            }
        }

        takeDamage(finalDamage);
    }

    public Character(String name, int health, int attackPower) {
        if (name == null)
            throw new IllegalArgumentException("name tidak boleh null");
        if (health < 0)
            throw new IllegalArgumentException("health harus >= 0");
        if (attackPower < 0)
            throw new IllegalArgumentException("attackPower harus >= 0");

        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("health tidak boleh negatif");
        }
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        if (attackPower < 0) {
            throw new IllegalArgumentException("attackPower tidak boleh negatif");
        }
        this.attackPower = attackPower;
    }

    protected void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0)
            this.health = 0;
    }

    public void takeDamage(int damage) {
        if (damage < 0)
            throw new IllegalArgumentException("damage tidak boleh negatif");
        reduceHealth(damage);
        System.out.println(getName() + " took " + damage + " damage! Remaining health: " + getHealth());
    }

    public abstract void attack(Character target);

    public final boolean isAlive() {
        return this.health > 0;
    }

    public final void performTurn(Character target) {
        if (!this.isAlive()) {
            System.out.println(getName() + " tidak dapat bertindak karena sudah kalah.");
            return;
        }

        for (StatusEffect e : effects) {
            e.onTurnStart(this);
        }

        System.out.println(getName() + " mulai giliran menyerang " + target.getName());
        this.attack(target);
        for (StatusEffect e : effects) {
            e.onTurnEnd(this);
        }
        Iterator<StatusEffect> it = effects.iterator();
        while (it.hasNext()) {
            StatusEffect e = it.next();
            if (e.isExpired()) {
                System.out.println(getName() + " kehilangan efek: " + e.getClass().getSimpleName());
                it.remove();
            }
        }
    }

    protected AttackStrategy attackStrategy;

    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
    }

}
