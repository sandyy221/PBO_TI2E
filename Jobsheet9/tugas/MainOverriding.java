package Jobsheet9.tugas;

public class MainOverriding {
    public static void main(String[] args) {
        Manusia m = new Manusia();
        m.bernafas();
        m.makan();

        System.out.println("-----");
        Dosen d = new Dosen();
        d.bernafas();
        d.makan();
        d.lembur();

        System.out.println("-----");
        Mahasiswa s = new Mahasiswa();
        s.bernafas();
        s.makan();
        s.tidur();
    }
}
