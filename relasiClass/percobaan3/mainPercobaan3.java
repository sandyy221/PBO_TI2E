package relasiClass.percobaan3;

public class mainPercobaan3 {
    public static void main(String[] args) {
        pegawai masinis = new pegawai("1234", "Spongebob Squarepants"); 
        pegawai asisten = new pegawai("4567", "Patrick Star"); 
        keretaApi keretaApi = new keretaApi("Gaya Baru", "Bisnis", masinis, asisten); 
        System.out.println(keretaApi.info()); 
    }
}
