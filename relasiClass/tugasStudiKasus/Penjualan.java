package relasiClass.tugasStudiKasus;

public class Penjualan {
    private Buku buku;
    private Pelanggan pelanggan;
    private Karyawan karyawan;
    private int kuantitas;

    public Penjualan(Buku buku, Pelanggan pelanggan, Karyawan karyawan, int kuantitas) {
        this.buku = buku; 
        this.pelanggan = pelanggan; 
        this.karyawan = karyawan;
        this.kuantitas = kuantitas;
    }
    public Buku getBuku() {
        return buku;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public int getKuantitas() {
        return kuantitas;
    }
    public double hitungTotal() {
        return this.buku.getHarga() * this.kuantitas;
    }
}
