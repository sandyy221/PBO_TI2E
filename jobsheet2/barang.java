package jobsheet2;

public class barang {
    public String namaBrg;
    public String jenisBrg;
    public int stok;

    public void tampilngBarang(){
        System.out.println("Nama Barang: " + namaBrg); 
        System.out.println("Jenis Barang: " + jenisBrg);
        System.out.println("Stok: " + stok); 
    }
    public int tambahStok (int brggMasuk){
        int stokBaru=brggMasuk+stok;

        return stokBaru;
    }
    
}
