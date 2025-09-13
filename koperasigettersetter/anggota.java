package koperasigettersetter;

public class anggota {
    private String nama;
    private String alamat;
    private float simpanan;

    anggota(String nama, String alamat){
        this.nama=nama;
        this.alamat=alamat;
        this.simpanan=0;
    }

    void setNama (String nama){
        this.nama=nama;
    }
    void setAlamatb(String alamat){
        this.alamat=alamat;
    }
    public String getNama(){
        return nama;
    }
    public String getAlamat(){
        return alamat;
    }
    public float getSimpanan(){
        return simpanan;
    }
    void setor (float uang){
        simpanan+=uang;
    }
    void pinjam (float uang){
        simpanan-=uang;
    }
}
