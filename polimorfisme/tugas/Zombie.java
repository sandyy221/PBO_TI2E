package polimorfisme.tugas;

public abstract class Zombie implements Destroyable {
    protected int health;
    protected int level;

    public Zombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    public abstract void heal();

    public String getZombieInfo() {
    return "Data =\nHealth = " + this.health + "\nLevel = " + this.level;
    }
    public int getHealth() {
        return health;
    }
    
    public int getLevel() {
        return level;
    }
}