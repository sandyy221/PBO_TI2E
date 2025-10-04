package inheritance.inheritance_teori;

public class TataTertib {
    private String peraturan;
    private String sanksi;

    public TataTertib(String peraturan, String sanksi) {
        this.peraturan = peraturan;
        this.sanksi = sanksi;
    }

    public String getPeraturan() {
        return peraturan;
    }

    public String getSanksi() {
        return sanksi;
    }

    public void terapkanSanksi(AnggotaKampus anggota) {
        System.out.println("Sanksi untuk " + anggota.getNama() + ": " + sanksi);
    }
}
