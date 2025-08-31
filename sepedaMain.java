public class sepedaMain {
    public static void main(String[] args) {
        // Buat dua buah objek sepeda
        sepedaDemo spd1 = new sepedaDemo();
        sepedaDemo spd2 = new sepedaDemo();

        // Panggil method didalam objek sepeda
        spd1.setMerek("Polygon");
        spd1.tambahKecepatan(10);
        spd1.gantiGear(2);
        spd1.cetakStatus();

        spd2.setMerek("Wim Cycle");
        spd2.tambahKecepatan(10);
        spd2.gantiGear(2);
        spd2.tambahKecepatan(10);
        spd2.gantiGear(3);
        spd2.cetakStatus();
    }
}