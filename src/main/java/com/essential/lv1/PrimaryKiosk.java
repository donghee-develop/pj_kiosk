package com.essential.lv1;

import java.util.Scanner;

public class PrimaryKiosk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" [ SHAKESHACK MENU ] ");
        System.out.print("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거\n");
        System.out.print("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거\n");
        System.out.print("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거\n");
        System.out.print("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거\n");
        System.out.print("0. 종료      | 종료\n");
        while (true){
            int choice = sc.nextInt();
            if(choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else if(choice == 1) {
                System.out.println("쉑버거를 선택하였습니다.");
            }
            else if(choice == 2) {
                System.out.println("스모크쉑을 선택하였습니다.");
            }
            else if(choice == 3) {
                System.out.println("치즈버거를 선택하였습니다.");
            }
            else if(choice == 4) {
                System.out.println("햄버거를 선택하였습니다.");
            }
            else{
                System.out.println("0~4만 입력해주세요.");
            }
        }

    }

}
