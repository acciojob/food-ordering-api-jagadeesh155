package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Food> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(Food food) {
        menuItems.add(food);
    }

    public List<Food> getMenuItems() {
        return menuItems;
    }

    public Food getMenuItemById(int id) {
        for (Food food : menuItems) {
            if (food.getId() == id) {
                return food;
            }
        }
        return null; // if not found
    }
}
