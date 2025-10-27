package Jobsheet9.teori;

public class Supervisor extends Manajer {

    public Supervisor(String nama, double gaji) {
        super(nama, gaji);
    }

    @Override
    public void naikkanGaji() {
        gaji += 1500000; 
    }
}
