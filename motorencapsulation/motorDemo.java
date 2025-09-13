package motorencapsulation;

public class motorDemo {
    public static void main(String[] args) {
        motor Motor = new motor();
        Motor.printStatus();
        Motor.tambahKecepatan();

        Motor.nyalakanMesin();
        Motor.printStatus();

        Motor.tambahKecepatan();
        Motor.printStatus();

        Motor.tambahKecepatan();
        Motor.printStatus();

        Motor.matikanMesin();
        Motor.printStatus();
    }
}
