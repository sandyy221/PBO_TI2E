package polimorfisme;

public class TestBayaran {

    public static void main(String[] args) {
        Manajer man = new Manajer("Agus", 800, 50);
        Programer prog = new Programer("Budi", 600, 30);

        Bayaran hr = new Bayaran();

        System.out.println("Bayaran manajer: " + hr.hitungBayaran(man));
        System.out.println("Bayaran programmer: " + hr.hitungBayaran(prog));
    }
}