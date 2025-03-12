package com.challenge;

import lombok.Getter;
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

    // { } yard 통해 return 명시
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