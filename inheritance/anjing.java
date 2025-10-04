package inheritance;

public class anjing extends Hewan {
    private String jenisBulu;

    public anjing(String nama, int umur, String jenisBulu) {
        super(nama, umur);
        this.jenisBulu=jenisBulu;
    }
    public String getJenisBulu() {
        return jenisBulu;
        
    }
    public void setJenisBulu(String jenisBulu) {
        this.jenisBulu = jenisBulu;
        
    }

    void menggonggong() {
        System.out.println("GUk guk!");
    }
}
