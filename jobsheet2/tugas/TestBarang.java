package jobsheet2.tugas;

public class TestBarang {
    public static void main(String[] args) {
        Barang brg1 = new Barang();

        brg1.kode = "ABC01";
        brg1.namaBarang = "PC Gaming";
        brg1.hargaDasar = 500000;
        brg1.diskon = 10;

        System.out.println("=== Data Barang ===");
        brg1.tampilData();
    }
}
