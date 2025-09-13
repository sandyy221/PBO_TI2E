package tugasJobsheet3;

public class Anggota {
    private String noKTP;
    private String nama;
    private int limitPinjaman;
    private int jumlahPinjaman;

    public Anggota(String noKTP, String nama, int limitPinjaman) {
        this.noKTP = noKTP;
        this.nama = nama;
        this.limitPinjaman = limitPinjaman;
        this.jumlahPinjaman = 0;
    }

    public String getNama() {
        return nama;
    }
    public int getLimitPinjaman() {
        return limitPinjaman;
    }
    public int getJumlahPinjaman() {
        return jumlahPinjaman;
    }
    public void pinjam(int uang) {
        if (jumlahPinjaman + uang > limitPinjaman) {
            System.out.println("Maaf, jumlah pinjaman melebihi limit.");
        } else {
            jumlahPinjaman += uang;
        }
    }

    public void angsur(int uang) {
        if (uang < (0.1 * jumlahPinjaman)) {
            System.out.println("Maaf, angsuran harus minimal 10% dari jumlah pinjaman saat ini.");
        } else {
            jumlahPinjaman -= uang;
        }
    }
}
