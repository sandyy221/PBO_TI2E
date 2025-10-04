package inheritance;

class Truck extends Kendaraan {
    int muatanMaks;

    public Truck(String merk, int tahunProduksi, int muatanMaks) {
        super(merk, tahunProduksi);
        this.muatanMaks = muatanMaks;
    }

    @Override
    void jalankan() {
        System.out.println("Truck " + merk + " sedang mengangkut barang...");
    }
    void info() {
        super.info();
        System.out.println("Muatan Max: " + muatanMaks + " kg");
    }
}
