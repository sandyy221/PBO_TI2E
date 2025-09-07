package jobsheet2;

public class testMahasiswa {
    public static void main(String[] args) {
        mahasiswa mhs1 = new mahasiswa();
        mahasiswa mhs2 = new mahasiswa();
        mahasiswa mhs3 = new mahasiswa();

        mhs1.nim=101;
        mhs1.nama="lestari";
        mhs1.alamat= "JL. vinola No 1A";
        mhs1.kelas="1A";
        mhs1.tampilBiodata();
        System.out.println();

        mhs2.nim=202;
        mhs2.nama="bayu";
        mhs2.alamat="JL. veteran No 2A";
        mhs2.kelas="1A";
        mhs2.tampilBiodata();
        System.out.println();

        mhs3.nim=303;
        mhs3.nama="anto";
        mhs3.alamat="JL. subroto No 3A";
        mhs3.kelas="1A";
        mhs3.tampilBiodata();
    }
    
}
