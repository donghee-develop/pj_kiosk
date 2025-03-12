package com.challenge;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class Menu {
    private String category;
    private List<MenuItem> menuItems;

    public Menu(String category) {
        this.category = category;
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void displayMenuItems() {
        System.out.println("\n[ " + category.toUpperCase() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d. %s | W %.1f | %s\n", i + 1,
                    menuItems.get(i).getName(),
                    menuItems.get(i).getPrice(),
                    menuItems.get(i).getDescription());
        }
        System.out.println("0. 뒤로가기");
    }
}