package inheritance.inheritance_teori;

public class Main {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("Sandy", "M001", "244107020029", "Informatika");
        Dosen d1 = new Dosen("Bpk.Irsyad", "D001", "654321", "PBO");

        TataTertib t1 = new TataTertib("Merokok pada area Kampus", "Memebersihkan WC");
        TataTertib t2 = new TataTertib("Tertidur saat rapat", "Teguran");

        Pelanggaran p1 = new Pelanggaran(m1, t1, "2025-10-05");
        Pelanggaran p2 = new Pelanggaran(d1, t2, "2025-10-06");

        SistemInformasiTataTertib sistem = new SistemInformasiTataTertib();
        sistem.catatPelanggaran(p1);
        sistem.catatPelanggaran(p2);
        sistem.lihatRiwayatPelanggaran(m1);
        sistem.lihatRiwayatPelanggaran(d1);
    }
}
