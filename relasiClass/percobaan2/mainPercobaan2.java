package relasiClass.percobaan2;

public class mainPercobaan2 {
    public static void main(String[] args) {
        mobil m = new mobil();
        m.setMerk("Avanza");
        m.setBiaya(350000);

        sopir s = new sopir();
        s.setNama("John Doe");
        s.setBiaya(150000);

        pelanggan p = new pelanggan();
        p.setNama("Jane Doe");
        p.setMobil(m);
        p.setSopir(s);
        p.setHari(2);
        System.out.println("Biaya total= " + 
        p.hitungiayaTotal());
        System.out.println("Pelanggan: " + p.getNama());
        System.out.println("Mobil: " + p.getMobil().getMerk());
        System.out.println("Sopir: " + p.getSopir().getNama());

    }
}
