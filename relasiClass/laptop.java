package relasiClass;

public class laptop {
    private String merk;
    private processor proc;

    public laptop(){

    }
    public laptop(String merk, processor proc){
        this.merk=merk;
        this.proc=proc;
    }
    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    public void setProc(processor proc) {
        this.proc = proc;
    }

    public processor getProc() {
        return proc;
    }
    public void info(){
        System.out.println("Merk laptop =" + merk);
        proc.info();
    }

}
