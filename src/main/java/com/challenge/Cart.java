package com.challenge;

import com.essential.lv2.MenuItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<MenuItem> items;
    private Integer totalCount;

    public Cart() {
        this.items = new ArrayList<>();
        this.totalCount = 0;
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

    }
}
