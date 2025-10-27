package Jobsheet9.teori;

public class Manajer {
    protected String nama;
    protected double gaji;

    public Manajer(String nama, double gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    public void naikkanGaji() {
        gaji += 1000000;
    }

    public void cetakStatus() {
        System.out.println("Nama : " + nama);
        System.out.println("Gaji : Rp " + gaji);
        System.out.println();
    }
}
