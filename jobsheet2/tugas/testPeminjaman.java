package jobsheet2.tugas;

public class testPeminjaman {
    public static void main(String[] args) {
        peminjaman p1 = new peminjaman();

        p1.id = 111;
        p1.namaMember = "Anto";
        p1.namaGame = "God Hands";
        p1.harga = 15000;  
        p1.lamaSewa = 3;  

        System.out.println("=== Data Peminjaman Game ===");
        p1.tampilDataPeminjaman();
    }
}
