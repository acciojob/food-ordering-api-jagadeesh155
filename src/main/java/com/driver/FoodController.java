package com.driver;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {
    private Menu menu;
    private Order currentOrder;

    public FoodController() {
        this.menu = new Menu();
        this.currentOrder = new Order();

        // Pre-populate menu
        menu.addMenuItem(new Food(1, "Pizza", 299.99));
        menu.addMenuItem(new Food(2, "Burger", 149.49));
        menu.addMenuItem(new Food(3, "Pasta", 199.00));
        menu.addMenuItem(new Food(4, "Sandwich", 99.99));
    }

    @GetMapping("/menu")
    public List<Food> getMenu() {
        return menu.getMenuItems();
    }

    @PostMapping("/order/{itemId}")
    public String placeOrder(@PathVariable int itemId) {
        Food food = menu.getMenuItemById(itemId);
        if (food != null) {
            currentOrder.addItem(food);
            return food.getName() + " added to order!";
        } else {
            return "Item not found!";
        }
    }

    @GetMapping("/order")
    public Order getCurrentOrder() {
        return currentOrder;
    }

    @GetMapping("/order/total")
    public double getTotalBill() {
        return currentOrder.getTotalBill();
    }
}
