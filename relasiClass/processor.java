package relasiClass;

public class processor {

    private String merk;
    private double cache;

    public processor(){

    }

    public processor(String merk, double cache){
        this.merk = merk;
        this.cache = cache;
    }

    public void setMerk(String merk){
        this.merk = merk;
    }
    public String getMerk (){
        return merk;
    }
    public void setCache(double cache){
        this.cache=cache;
    }
    public double getCache(){
        return cache;
    }

    public void info (){
        System.out.println("Merk Processor = " + merk);
        System.out.println("Cache memory = " + cache );
    }
}