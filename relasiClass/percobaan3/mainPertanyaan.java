package relasiClass.percobaan3;

public class mainPertanyaan {
    public static void main(String[] args) {
    pegawai masinis = new pegawai("1234", "Spongebob Squarepants"); 
    keretaApi keretaApi = new keretaApi("Gaya Baru", "Bisnis", masinis);
    System.out.println(keretaApi.info());   
    }
}
