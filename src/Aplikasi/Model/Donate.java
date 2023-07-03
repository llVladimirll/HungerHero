package Aplikasi.Model;

import java.lang.reflect.Constructor;

public class Donate {
    private String foodItem;
    private String date;
    private int amount;
    private String pickUp;

    public Donate(String foodItem, String date, int amount, String pickUp){
        this.foodItem = foodItem;
        this.date = date;
        this.amount = amount;
        this.pickUp = pickUp;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
    
    public String getPickUp() {
        return pickUp;
    }
    
}
