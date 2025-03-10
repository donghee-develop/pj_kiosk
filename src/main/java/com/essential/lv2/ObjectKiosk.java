package com.essential.lv2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectKiosk {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티"));
        Scanner scanner = new Scanner(System.in);

        while(true) {
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i).getName() + "  가격 : " + menuItems.get(i).getPrice() + "  설명 : " +menuItems.get(i).getDescription());
            }
            int choice = scanner.nextInt();
            if(choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                scanner.close();
                break;
            }
            else if(choice == 1) {
                System.out.println("쉑 버거를 선택하였습니다.");
            }
            else if(choice == 2) {
                System.out.println("스모크버커를 선택하였습니다.");
            }
            else if(choice == 3) {
                System.out.println("치즈버거를 선택하였습니다.");
            }
            else if(choice == 4) {
                System.out.println("햄버거를 선택하였습니다");
            }
            else {
                System.out.println("0~4까지의 값만 선택해주세요");
            }
        }

    }
}
