package Praktikum;

public class hewanMain {
    public static void main(String[] args) {
        hewan h1 = new hewan();
        h1.setNama("hewan berbulu");
        h1.setUmur(1);
        h1.cetakInfo();
        h1.dudukDiam();
        h1.bermain();
        System.out.println();

        kucing k1 = new kucing();
        k1.setNama("kucing");
        k1.setUmur(1);
        k1.setWarnaBulu("mujair");
        k1.setRas("jawa");
        k1.cetakInfo();
        k1.mengeong();
        k1.mencakar();

        System.out.println();

        anjing a1 = new anjing();
        a1.setNama("anjing");
        a1.setUmur(1);
        a1.setJenis("kampung");
        a1.setUkuran("kecil");
        a1.cetakInfo();
        a1.menggonggong();
        a1.menjagaRumah();

        System.out.println();

        burung b1 =new burung();
        b1.setWarnaBulu("hitam");
        b1.setBisaTerbang(true);
        b1.cetakInfo();
        b1.berkicau();
        b1.terbang();
    }
}