package polimorfisme.tugas;

public class Barrier implements Destroyable {
    private int strength;

    public Barrier(int strength) {
        this.strength = strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public void destroyed() {
        this.strength -= 9; 
        if (this.strength < 0) {
            this.strength = 0; 
        }
    }
    public String getBarrierInfo() {
        return "" + this.strength;
    }
}