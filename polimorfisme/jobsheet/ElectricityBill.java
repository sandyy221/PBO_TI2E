package polimorfisme.jobsheet;

public class ElectricityBill implements Payable {
    private int kWh;
    private String category;

    public ElectricityBill(int kWh, String category) {
        this.kWh = kWh;
        this.category = category;
    }

    public int getKwh() {
        return kWh;
    }

    public void setKwh(int kWh) {
        this.kWh = kWh;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int getPaymentAmount() {
        return kWh * getBasePrice();
    }

    public int getBasePrice() {
        int price = 0;
        switch (category) {
            case "R-1":
                price = 100;
                break;
            case "R-2":
                price = 200;
                break;
        }
        return price;
    }

    public String getBillInfo() {
        return "kWh = " + kWh + "\n" +
               "Category = " + category + 
               " (" + getBasePrice() + " per kWh)\n";
    }
}
