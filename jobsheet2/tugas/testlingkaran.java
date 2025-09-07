package jobsheet2.tugas;

public class testlingkaran {
    public static void main(String[] args) {
        lingkaran ling1 = new lingkaran();
        ling1.r = 7;

        System.out.println("=== Hitung Lingkaran ===");
        System.out.println("Jari-jari   : " + ling1.r);
        System.out.println("Luas        : " + ling1.hitungLuas());
        System.out.println("Keliling    : " + ling1.hitungKeliling());
    }
}
