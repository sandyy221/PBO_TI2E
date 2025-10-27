package Jobsheet9.teori;

public class SalesManajer extends Manajer {
    private String departemen;

    public SalesManajer(String nama, String departemen, double gaji) {
        super(nama, gaji);
        this.departemen = departemen;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    @Override
    public void cetakStatus() {
        System.out.println("Data Sales Manager");
        System.out.println("Nama       : " + nama);
        System.out.println("Departemen : " + departemen);
        System.out.println("Gaji       : " + gaji);
        System.out.println();
    }
}