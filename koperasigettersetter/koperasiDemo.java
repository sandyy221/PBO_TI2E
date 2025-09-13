package koperasigettersetter;

public class koperasiDemo {
    public static void main(String[] args) {
        anggota Anggota1= new anggota("Iwan", "Jalan Mawar");
        System.out.println("Simpanan " + Anggota1.getNama()+ " : Rp " + Anggota1.getSimpanan());

        Anggota1.setNama("Iwan Setiono");
        Anggota1.setAlamatb("Jalan Sukarno Hata No.10");
        Anggota1.setor(100000);
        System.out.println("Simpanan " + Anggota1.getNama()+ " : Rp " + Anggota1.getSimpanan());

        Anggota1.pinjam(5000);
        System.out.println("Simpanan " + Anggota1.getNama() + " : Rp " + Anggota1.getSimpanan());
    }
}
