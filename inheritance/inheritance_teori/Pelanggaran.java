package inheritance.inheritance_teori;

public class Pelanggaran {
    private AnggotaKampus pelanggar;
    private TataTertib peraturanDilanggat;
    private String tanggal;

    public Pelanggaran(AnggotaKampus pelanggar, TataTertib peraturanDilanggat, String tanggal) {
        this.pelanggar = pelanggar;
        this.peraturanDilanggat = peraturanDilanggat;
        this.tanggal = tanggal;
    }

    public AnggotaKampus getPelanggar() {
        return pelanggar;
    }

    public TataTertib getPeraturanDilanggat() {
        return peraturanDilanggat;
    }

    public String getTanggal() {
        return tanggal;
    }
}
