package com.essential.lv3;

import com.challenge.Cart;
import com.essential.lv2.MenuItem;
import com.essential.lv4.Menu;
import lombok.Data;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
@Data
public class Kiosk {
    private List<Menu> menus;
    private final Scanner scanner;

    public Kiosk() {
        menus = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료");

    }
    public void add(Menu menu) {
        menus.add(menu);
    }
    // LV3
    public void start(List<MenuItem> menuItem) {
        while (true){
            System.out.println("[ Shack MENU ]");




            for(int i = 0; i < menuItem.size(); i++){
                System.out.println((i+1) + ". " + menuItem.get(i).getName() + " 가격 : " + menuItem.get(i).getPrice() + " 설명 : " + menuItem.get(i).getDescription());
            }
            int choice = scanner.nextInt();

            if(choice == 0){
                System.out.println("프로그램 종료");
                break;
            }
            else {
                if(choice >= 1 && choice <= menuItem.size()){
                    MenuItem selectedItem = menuItem.get(choice - 1);
                    System.out.printf("선택한 메뉴 : %s | W %.1f | %s\n",
                            selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());
                } else {
                    System.out.println("잘못된 입력 0~4까지 입력하세요");
                }
            }
        }
    }
    // LV4
    public void start() {
        List<String> categories = new ArrayList<>();
        Cart cart = new Cart();

        for(Menu menu : menus) {
            categories.add(menu.getCategory());
        }
        displayMenu();

        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0) {
                    System.out.println("종료");
                    break;
                }
                Menu selectedMenu = menus.get(choice - 1);
                selectedMenu.displayMenuItems();
                int itemChoice = scanner.nextInt();
                scanner.nextLine();

                if (itemChoice == 0) {
                    System.out.println("뒤로 가기");
                    displayMenu();
                } else if (itemChoice >= 1 && itemChoice <= selectedMenu.getMenuItemList().size()) {
                    MenuItem selectedItem = selectedMenu.getMenuItemList().get(itemChoice - 1);
                    System.out.printf("선택한 메뉴 : %s | W %.1f | %s\n",
                            selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());

                    System.out.println("장바구니에 추가하겠습니까?");
                    System.out.println("1 확인 2 취소");
                    int cartChoice = scanner.nextInt();

                    if(cartChoice ==1){
                        cart.addItem(selectedItem,1);
                        cart.displayCart();
                    }
                    else if(cartChoice ==2){
                        System.out.println("취소되었습니다.");
                        displayMenu();
                    }
                } else {
                    System.out.println("잘못된 입력 0~" + selectedMenu.getMenuItemList().size() + "까지 입력하세요");
                }
            }
            catch (InputMismatchException e){
                System.out.println("숫자 입력해주세요.");
                scanner.nextLine();
                displayMenu();
            }
            catch (Exception e) {
                System.out.println("선택된 메뉴가 없습니다.");
                displayMenu();
            }
        }
    }
}
