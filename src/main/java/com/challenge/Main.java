package com.challenge;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date");

        int n = 2;
        words.sort(Comparator.comparing(s -> s.charAt(n)));
        System.out.println(words);

    }

}
