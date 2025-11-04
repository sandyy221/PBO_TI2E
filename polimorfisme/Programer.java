package polimorfisme;

public class Programer extends Pegawai {
    private int bonus;

    public Programer(String nama, int gaji, int bonus) {
        super(nama, gaji);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public int getGaji() {
        return super.getGaji() + bonus;
    }
}