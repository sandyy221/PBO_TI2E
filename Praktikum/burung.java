package Praktikum;

public class burung {
    private String warnaBulu;
    private boolean bisaTerbang;

    public void setWarnaBulu(String newValue) {
        warnaBulu = newValue;
    }

    public void setBisaTerbang(boolean newValue) {
        bisaTerbang = newValue;
    }

    public void cetakInfo() {
        System.out.println("Warna bulu: " + warnaBulu);
        System.out.println("Bisa terbang: " + bisaTerbang);
    }

    public void berkicau() {
        System.out.println("Burung sedang berkicau.");
    }

    public void terbang() {
        if (bisaTerbang) {
            System.out.println("Burung terbang tinggi.");
        } else {
            System.out.println("Burung tidak bisa terbang.");
        }
    }
}