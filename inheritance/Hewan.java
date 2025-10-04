package inheritance;

class Hewan {
    private String nama;
    protected int umur;

    public Hewan(String nama, int umur) {
        this.setNama(nama);
        this.umur=umur;
    }
    public String getNama() {
        return nama;
        
    }
    public void setNama(String nama) {
        this.nama = nama;
        
    }
    public void berjalan(){
        System.out.println(getNama() + " berjalan...");
    }
    public void info(){
        System.out.println("Nama: " + getNama());
        System.out.println("Umur: " + umur);
    }
}