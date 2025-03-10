package com.essential.lv4;

import com.essential.lv2.MenuItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Menu {
    private String category;
    private List<MenuItem> menuItemList;

    public Menu(String category) {
        this.category = category;
        this.menuItemList = new ArrayList<>();
    }
    public void add(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }
    public void displayMenuItems() {
        System.out.println("[ " + category + " MENU" + " ]");
        for (int i = 0; i < menuItemList.size(); i++) {
            System.out.println((i + 1) + ". " + menuItemList.get(i).getName() + " 가격 : " + menuItemList.get(i).getPrice() + " 설명 : " + menuItemList.get(i).getDescription());
        }
    }
}
