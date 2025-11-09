package polimorfisme.tugas;

public class JumpingZombie extends Zombie {

    public JumpingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        double increasePercentage = 0;
        if (this.level == 1) increasePercentage = 0.30;
        else if (this.level == 2) increasePercentage = 0.40;
        else if (this.level == 3) increasePercentage = 0.50;
        this.health += (int) (this.health * increasePercentage);
    }

    @Override
    public void destroyed() {
        double reductionPercentage = 0.10; 
        int reduction = (int) (this.health * reductionPercentage);
        this.health -= reduction;
    }
}