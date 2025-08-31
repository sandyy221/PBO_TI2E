package Praktikum;

public class kucing extends hewan {
    String warnaBulu;
    String ras;

    public void setWarnaBulu(String newValue) {
        warnaBulu = newValue;
    }

    public void setRas(String newValue) {
        ras = newValue;
    }

    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Warna Bulu: " + warnaBulu);
        System.out.println("Ras: " + ras);
    }

    public void mengeong() {
        System.out.println("Kucing mengeong");
    }

    public void mencakar() {
        System.out.println("Kucing sedang duduk");
    }
}