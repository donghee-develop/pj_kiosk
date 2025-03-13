package com.challenge;

import lombok.Data;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
@Data
public class Cart {
    private List<MenuItem> items;
    private static final Scanner scanner = new Scanner(System.in);

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
        System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
    }
    public Double discountTotalPrice(double total) {
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10%");
        System.out.println("2. 군인     :  5%");
        System.out.println("3. 학생     :  3%");
        System.out.println("4. 일반     :  0%");
        double discountedPrice;
        int discountChoice = scanner.nextInt();
        //         일반, 마지막에는 throw new exception을 통해 반환
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
//        throw new IllegalArgumentException("잘못된 입력입니다. 다시 선택하세요");

//        enum
        Discount discount = Discount.getChoice(discountChoice);
        discountedPrice = total * (1 - discount.getDiscountRate());
        return discountedPrice;
    }
        public void displayCart () {
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
            try {
                int orderChoice = scanner.nextInt();

                if (orderChoice == 1) {
                    double discountedTotalPrice = discountTotalPrice(total);
                    System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", discountedTotalPrice);
                    items.clear();
                } else if (orderChoice == 2) {
                    System.out.println("메뉴판으로 돌아갑니다.");
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다. 다시 선택하세요");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력하세요");
            }

        }

        public void clearCart () {
            if (items.isEmpty()) {
                System.out.println("장바구니가 비어 있습니다.");
            } else {
                items.clear();
                System.out.println("주문이 취소되었습니다.");
            }
        }

}
