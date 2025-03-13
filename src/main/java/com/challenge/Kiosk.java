package com.challenge;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
class Kiosk {
    private List<Menu> menus;
    private Cart cart;
    private final Scanner scanner;

    public Kiosk() {
        this.menus = new ArrayList<>();
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
    }

    // 메뉴 추가
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void displayMainMenu() {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        if (!cart.getItems().isEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
        System.out.println("0. 종료");
    }

    // 키오스크 시작
    public void start() {
        while (true) {
            try {
                displayMainMenu();
                System.out.print("메뉴 선택: ");
                int choice = Integer.parseInt(scanner.nextLine());

                System.out.println("choice : " +choice);
                if (choice == 0) {
                    System.out.println("프로그램 종료");
                    break;
                } else if (choice >= 1 && choice <= menus.size()) {
                    selectMenu(menus.get(choice - 1));
                } else if (choice == 4 && !cart.getItems().isEmpty()) {
                    cart.displayCart();
                } else if (choice == 5 && !cart.getItems().isEmpty()) {
                    cart.clearCart();
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다. 다시 선택하세요");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요");
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // 특정 메뉴 선택 후 항목 표시
    public void selectMenu(Menu menu) {
        while (true){
        try {
            menu.displayMenuItems();
            System.out.print("메뉴 선택 (0: 뒤로가기): ");
            int choice =  Integer.parseInt(scanner.nextLine());

            if (choice == 0) return;

            if (choice >= 1 && choice <= menu.getMenuItems().size()) {
                MenuItem selectedItem = menu.getMenuItems().get(choice - 1);
                System.out.printf("\n선택한 메뉴: %s | W %.1f | %s\n",
                        selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());

                System.out.println("이 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인  2. 취소");
                int cartChoice = scanner.nextInt();
                scanner.nextLine();

                if (cartChoice == 1) {
                    cart.addItem(selectedItem);
                } else if (cartChoice == 2) {
                    System.out.println("담기를 취소하였습니다.");
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다. 다시 선택하세요");
                }
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다. 다시 선택하세요");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        }
    }
}

