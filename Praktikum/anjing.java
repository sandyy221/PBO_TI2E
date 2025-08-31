package Praktikum;

public class anjing extends hewan {
    private String jenis;
    private String ukuran;

    public void setJenis(String newValue) {
        jenis = newValue;
    }

    public void setUkuran(String newValue) {
        ukuran = newValue;
    }

    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Jenis: " + jenis);
        System.out.println("Ukuran: " + ukuran);
    }

    public void menggonggong() {
        System.out.println("Anjing menggonggong");
    }

    public void menjagaRumah() {
        System.out.println("Anjing sedang menjaga rumah.");
    }
}
