package relasiClass.percobaan4;

public class MainPercobaan4 {
    public static void main(String[] args) {
        Penumpang budi =new Penumpang("321", "budi");
        Penumpang p = new Penumpang("12345", "Mr. Krab"); 
        Gerbong gerbong = new Gerbong("A", 10); 
        
        

        gerbong.setPenumpang(budi, 1);
        gerbong.setPenumpang(p, 1);
        System.out.println(gerbong.info()); 
    }
}

