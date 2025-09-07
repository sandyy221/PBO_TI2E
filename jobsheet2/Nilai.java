package jobsheet2;

public class Nilai {
    mahasiswa mahasiswa;
    mataKuliah mataKuliah;
    int nilai;

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public void tampilNilai() {
        System.out.println("Nilai untuk " + mahasiswa.nama + 
                           " pada mata kuliah " + mataKuliah.namaMK + 
                           " adalah: " + nilai);
    }
}
