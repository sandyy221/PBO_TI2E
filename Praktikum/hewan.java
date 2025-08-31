package Praktikum;

public class hewan {
    private String nama;
    private int umur;

    public void setNama(String newValue) {
        nama = newValue;
    }

    public void setUmur(int newValue) {
        umur = newValue;
    }

    public void cetakInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur + " tahun");
    }

    public void dudukDiam() {
        System.out.println(nama + " sedang duduk diam.");
    }

    public void bermain() {
        System.out.println(nama + " sedang bermain.");
    }
}

