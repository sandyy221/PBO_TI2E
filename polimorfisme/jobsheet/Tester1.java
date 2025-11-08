package polimorfisme.jobsheet;

public class Tester1 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "R-1");

        Employee e;
        Payable p;

        e = pEmp;
        p = pEmp;
        p = eBill;

    }
}
