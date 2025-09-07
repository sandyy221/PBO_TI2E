package jobsheet2;

public class dosen {
    String nidn;
    String nama;

    public void inputNilai(Nilai n, int nilai) {
        n.setNilai(nilai);
        System.out.println("Dosen " + nama + " berhasil input nilai: " + nilai);
    }
}

