package com.essential.lv4;

import com.essential.lv2.MenuItem;
import com.essential.lv3.Kiosk;

public class OOPKioskWithMenu {
    public static void main(String[] args) {
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료 메뉴 생성
        Menu drinkMenu = new Menu("Drinks");
        drinkMenu.add(new MenuItem("Lemonade", 3.5, "레모네이드"));
        drinkMenu.add(new MenuItem("Coke", 2.5, "콜라"));

        // 디저트 메뉴 생성
        Menu dessertMenu = new Menu("Desserts");
        dessertMenu.add(new MenuItem("Ice Cream", 4.0, "바닐라 아이스크림"));
        dessertMenu.add(new MenuItem("Brownie", 5.0, "초콜릿 브라우니"));

        Kiosk kiosk = new Kiosk();
        kiosk.add(burgerMenu);
        kiosk.add(drinkMenu);
        kiosk.add(dessertMenu);

        kiosk.start();
    }
}
