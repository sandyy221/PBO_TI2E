package relasiClass;

public class mainPercobaan1 {
    public static void main(String[] args) {
        processor p = new processor("Intel i5", 3);
        laptop l = new laptop("Thinkpad", p);

        l.info();

        processor p1 =new processor();
        p1.setMerk("Intel i5");
        p1.setCache(4);

        laptop l1 = new laptop();
        l1.setMerk("Thinkpad");
        l1.setProc(p1);
        l1.info();
    }
}
