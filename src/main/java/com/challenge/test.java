package com.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

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
            displayMainMenu();
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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
                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }

    // 특정 메뉴 선택 후 항목 표시
    private void selectMenu(Menu menu) {
        menu.displayMenuItems();
        System.out.print("메뉴 선택 (0: 뒤로가기): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

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
            }
        } else {
            System.out.println("잘못된 입력입니다. 다시 선택하세요.");
        }
    }
}

// 장바구니 (Cart)
@Data
class Cart {
    private List<MenuItem> items;
    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
        System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
    }
    public Double discountTotalPrice(double total){
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10%");
        System.out.println("2. 군인     :  5%");
        System.out.println("3. 학생     :  3%");
        System.out.println("4. 일반     :  0%");
        double discountedPrice = 0;
        Scanner scanner = new Scanner(System.in);
        int discountChoice = scanner.nextInt();
        // 일반
//        if(discountChoice == 1){
//            discountedPrice = total - 0.1*total;
//            return discountedPrice;
//        }
//        else if(discountChoice == 2){
//            discountedPrice = total - 0.05*total;
//            return discountedPrice;
//        }
//        else if(discountChoice == 3){
//            discountedPrice = total - 0.03*total;
//            return discountedPrice;
//        }
//        else if(discountChoice == 4){
//            discountedPrice = total - 0.01*total;
//            return discountedPrice;
//        }
//        else{
//            System.out.println("입력 오류 ");
//        }

//        enum
        Discount discount = Discount.getChoice(discountChoice);
        discountedPrice = total * (1 - discount.getDiscountRate());
        return discountedPrice;
    }
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }

        System.out.println("\n[ Orders ]");
        double total = 0;
        for (MenuItem item : items) {
            System.out.printf("%s | W %.1f | %s\n", item.getName(), item.getPrice(), item.getDescription());
            total += item.getPrice();
        }
        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f\n", total);

        System.out.println("\n1. 주문  2. 메뉴판");
        Scanner scanner = new Scanner(System.in);
        int orderChoice = scanner.nextInt();

        if (orderChoice == 1) {
            double discountedTotalPrice = discountTotalPrice(total);
            System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", discountedTotalPrice);
            items.clear();
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
        }
    }

    public void clearCart() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            items.clear();
            System.out.println("주문이 취소되었습니다.");
        }
    }
}

// 메뉴 (Menu)
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

@AllArgsConstructor
@Data
class MenuItem {
    private String name;
    private Double price;
    private String description;
}
@Getter
enum Discount {
    국가유공자(0.10),
    군인(0.05),
    학생(0.03),
    일반(0.00);

    private final double discountRate;

    Discount (double discountRate) {
        this.discountRate = discountRate;
    }

    public static Discount getChoice(int discountChoice) {
        return switch (discountChoice) {
            case 1 -> 국가유공자;
            case 2 -> 군인;
            case 3 -> 학생;
            case 4 -> 일반;
            default -> throw new IllegalArgumentException("잘못된 입력입니다.");
        };
    }
}
public class test {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinkMenu = new Menu("Drinks");
        drinkMenu.addMenuItem(new MenuItem("Lemonade", 3.5, "레몬에이드"));
        drinkMenu.addMenuItem(new MenuItem("Coke", 2.5, "콜라"));

        Menu dessertMenu = new Menu("Desserts");
        dessertMenu.addMenuItem(new MenuItem("Ice Cream", 4.0, "바닐라 아이스크림"));
        dessertMenu.addMenuItem(new MenuItem("Brownie", 5.0, "초콜릿 브라우니"));

        kiosk.addMenu(burgerMenu);
        kiosk.addMenu(drinkMenu);
        kiosk.addMenu(dessertMenu);

        kiosk.start();
    }
}
