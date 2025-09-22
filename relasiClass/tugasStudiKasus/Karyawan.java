package relasiClass.tugasStudiKasus;

public class Karyawan {
    private String idKaryawan;
    private String nama;

    public Karyawan(String idKaryawan, String nama) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
    }
    public String getIdKaryawan() {
        return idKaryawan;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
}
