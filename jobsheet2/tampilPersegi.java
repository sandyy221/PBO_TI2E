package jobsheet2;

public class tampilPersegi {
    public static void main(String[] args) {
        persegi p1 = new persegi();

        p1.sisi = 5;
        p1.dataPersegi();
        System.out.println("Luas persegi     : " + p1.luasPersegi());
        System.out.println("Keliling persegi : " + p1.kelilingPersegi());
    }
}
