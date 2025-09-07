package jobsheet2;

public class testBarang {
    public static void main(String[] args) {
        barang brg1 = new barang();
        brg1.namaBrg="Pensil";
        brg1.jenisBrg="ATK";
        brg1.stok=10;
        brg1.tampilngBarang();

        System.out.println("Stok baru adalah " + brg1.tambahStok(20));
    }
    
}
