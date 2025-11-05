package polimorfisme;

public class Manusia {

    public void nyalakanPerangkat(Elektronik perangkat) {

        if (perangkat instanceof TelevisiJadul) {
            TelevisiJadul tv = (TelevisiJadul) perangkat;
            System.out.println("Nyalakan televisi jadul dengan input: " + tv.getModelInput());
            System.out.println("Voltase televisi: " + tv.getVoltase());
        } 
        else if (perangkat instanceof TelevisiModern) {
            TelevisiModern tv = (TelevisiModern) perangkat;
            System.out.println("Nyalakan televisi modern dengan input: " + tv.getModelInput());
            System.out.println("Voltase televisi: " + tv.getVoltase());
        }
    }
}
