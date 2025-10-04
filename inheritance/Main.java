package inheritance;

public class Main {
    public static void main(String[] args) {
        Kucing kucing = new Kucing("Milo",2, "Oranye");
        anjing anj1 = new anjing("Anu", 100, "Lembut");

        kucing.info();
        kucing.berjalan();
        System.out.println(kucing.getNama());
        System.out.println(kucing.umur);
        
        anj1.info();
        anj1.berjalan();
        System.out.println(anj1.getNama());
        System.out.println(anj1.getJenisBulu());
        System.out.println(anj1.umur);
    }
}