package com.test;


import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        int sum = 0;
        for(int i =0; i<count; i++){
            sum += 2*price;
            System.out.println(sum);
        }
        System.out.println(sum - money);

    }
}
