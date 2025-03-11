package com.essential.lv4;

import com.essential.lv2.MenuItem;
import com.essential.lv3.Kiosk;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
public class Cart {
    private List<MenuItem> items;
    private Integer totalCount;
    private Kiosk kiosk;

    public Cart(Kiosk kiosk, List<MenuItem> items) {
        this.items = items;
        this.totalCount = 0;
        this.kiosk = kiosk;
    }
    public void addItem(MenuItem item,int count) {
        for(int i=0; i<count; i++) {
            this.items.add(item);
        }
        this.totalCount += count;
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for(MenuItem item : this.items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    public void displayCart(){
        System.out.println("장바구니 목록 ");
        if(items.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }

        for(MenuItem item : items){
            System.out.printf("%s | W %.1f | %s\n", item.getName(), item.getPrice(), item.getDescription());
        }
        System.out.println("총 개수 : " + totalCount);
        System.out.println("총 가격 : " + getTotalPrice());
        System.out.println("장바구니에 추가 되었습니다.");

        kiosk.start();

    }
}
