package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Food> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(Food food) {
        items.add(food);
    }

    public List<Food> getItems() {
        return items;
    }

    public double getTotalBill() {
        double totalBill = 0;
        for (Food food : items) {
            totalBill += food.getPrice();
        }
        return totalBill;
    }
}
