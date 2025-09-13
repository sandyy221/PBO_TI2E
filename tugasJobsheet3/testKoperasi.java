package tugasJobsheet3;
import java.util.Scanner;

public class testKoperasi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Anggota donny = new Anggota("111333444", "Donny", 5000000);

        System.out.println("Nama Anggota: " + donny.getNama());
        System.out.println("Limit Pinjaman: " + donny.getLimitPinjaman());

        System.out.print("\nMasukkan jumlah pinjaman: ");
        int pinjam = sc.nextInt();
        donny.pinjam(pinjam);
        System.out.println("Jumlah pinjaman saat ini: " + donny.getJumlahPinjaman());

        System.out.print("\nMasukkan jumlah angsuran: ");
        int angsur = sc.nextInt();
        donny.angsur(angsur);
        System.out.println("Jumlah pinjaman saat ini: " + donny.getJumlahPinjaman());
    }
}
