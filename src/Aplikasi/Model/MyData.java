package Aplikasi.Model;

public class MyData {
    private Double amount;
    private String date;
    public MyData(String date, String unit) {
        this.date = date;
        this.unit = unit;
    }

    private String item;
    private String unit;

    public MyData(Double amount, String date, String item, String unit) {
        this.amount = amount;
        this.date = date;
        this.item = item;
        this.unit = unit;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
