package inheritance.inheritance_teori;
import java.util.ArrayList;

public class SistemInformasiTataTertib {
    private ArrayList<Pelanggaran> daftarPelanggaran = new ArrayList<>();

    public void catatPelanggaran(Pelanggaran pelanggaran) {
        daftarPelanggaran.add(pelanggaran);
        System.out.println("Pelanggaran dicatat untuk: " + pelanggaran.getPelanggar().getNama());
    }

    public void lihatRiwayatPelanggaran(AnggotaKampus anggota) {
        System.out.println("\nRiwayat Pelanggaran untuk " + anggota.getNama());
        for (Pelanggaran p : daftarPelanggaran) {
            if (p.getPelanggar().equals(anggota)) {
                System.out.println(p.getPeraturanDilanggat().getPeraturan() + " " +p.getTanggal());
                p.getPeraturanDilanggat().terapkanSanksi(anggota);
            }
        }
    }
}
