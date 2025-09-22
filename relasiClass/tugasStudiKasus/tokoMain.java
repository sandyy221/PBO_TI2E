package relasiClass.tugasStudiKasus;

public class tokoMain {
    public static void main(String[] args) {
        Buku buku1 = new Buku("sikancil anak nakal", "suminto", 150000.0);
        Pelanggan pelanggan1 = new Pelanggan("P01", "Budi Santoso");
        Karyawan karyawan1 = new Karyawan("E11", "Tutik");

        System.out.println("Judul buku: " + buku1.getJudul());
        System.out.println("Nama pelanggan: " + pelanggan1.getNama());

        buku1.setHarga(145000.0);
        System.out.println("Harga buku setelah diskon: Rp" + buku1.getHarga());

        Penjualan penjualan1 = new Penjualan(buku1, pelanggan1, karyawan1, 2);
        System.out.println("Buku yang dibeli: " + penjualan1.getBuku().getJudul());
        System.out.println("Dibeli oleh: " + penjualan1.getPelanggan().getNama());
        System.out.println("Dilayani oleh: " + penjualan1.getKaryawan().getNama());
        System.out.println("Total harga: Rp" + penjualan1.hitungTotal());
    }
}
