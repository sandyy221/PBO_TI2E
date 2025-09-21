package relasiClass.percobaan4;

public class Gerbong {
    private String kode;
    private Kursi[] arrayKursi;

    public Gerbong(String kode, int jumlah) {
        this.kode = kode;
        this.arrayKursi = new Kursi[jumlah];
        this.initKursi();
    }

    private void initKursi() {
        for (int i = 0; i < arrayKursi.length; i++) {
            this.arrayKursi[i] = new Kursi(String.valueOf(i + 1));
        }
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public void setPenumpang(Penumpang penumpang, int nomor) {
        if (nomor > 0 && nomor <= arrayKursi.length) {
            Kursi kursi = this.arrayKursi[nomor - 1];
        
            if (kursi.getPenumpang() == null) {
                kursi.setPenumpang(penumpang);
            } else {
                System.out.println("Kursi nomor " + nomor + " sudah ditempati oleh " 
                + kursi.getPenumpang().getNama());
            }
        } 
        
    }

    public Kursi[] getArrayKursi() {
        return arrayKursi;
    }
    public String info() {
        String info = ""; info += "Kode: " + kode + "\n"; 
        for (Kursi kursi : arrayKursi) { 
            info += kursi.info(); 
        } 
        return info;
    }
}
