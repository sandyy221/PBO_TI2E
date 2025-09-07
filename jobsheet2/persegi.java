package jobsheet2;

public class persegi {
    int sisi;

    public void dataPersegi() {
        System.out.println("Panjang sisi persegi: " + sisi);
    }

    public int luasPersegi() {
        return sisi * sisi;
    }

    public int kelilingPersegi() {
        return 4 * sisi;
    }
}

