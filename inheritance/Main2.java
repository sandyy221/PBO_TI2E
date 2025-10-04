package inheritance;

public class Main2 {
    public static void main(String[] args) {
        Mobil mobil1 = new Mobil("Toyota", 2022, 4);
        Motor motor1 = new Motor("Honda", 2023, 150);
        Truck truck1 = new Truck("Tesla", 2030, 1000);

        mobil1.info();
        mobil1.jalankan();
        System.out.println("-----");
        motor1.info();
        motor1.jalankan();
        System.out.println("-----");
        truck1.info();
        truck1.jalankan();

    }
}
