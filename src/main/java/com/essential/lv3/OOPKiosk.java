package com.essential.lv3;

import com.essential.lv2.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class OOPKiosk {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티"));


        Kiosk kiosk = new Kiosk();
        kiosk.start(menuItems);
    }
}
