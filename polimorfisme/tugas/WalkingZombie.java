package polimorfisme.tugas;

public class WalkingZombie extends Zombie {

    public WalkingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        double increasePercentage = 0;
        if (this.level == 1) increasePercentage = 0.20;
        else if (this.level == 2) increasePercentage = 0.30;
        else if (this.level == 3) increasePercentage = 0.40;
        this.health += (int) (this.health * increasePercentage);
    }

    @Override
    public void destroyed() {
        this.health -= 14; 
    }
}