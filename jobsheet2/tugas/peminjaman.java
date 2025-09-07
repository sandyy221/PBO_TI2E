package jobsheet2.tugas;

public class peminjaman {
    public int id;
    public String namaMember;
    public String namaGame;
    public int harga;     
    public int lamaSewa;

    public int hitungHargaBayar() {
        return lamaSewa * harga;
    }
    public void tampilDataPeminjaman() {
        System.out.println("ID Member   : " + id);
        System.out.println("Nama Member : " + namaMember);
        System.out.println("Nama Game   : " + namaGame);
        System.out.println("Harga/Hari  : Rp " + harga);
        System.out.println("Lama Sewa   : " + lamaSewa + " hari");
        System.out.println("Total Bayar : Rp " + hitungHargaBayar());
    }
}

