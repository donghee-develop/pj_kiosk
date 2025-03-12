package com.challenge;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class MenuItem {
    private String name;
    private Double price;
    private String description;
}
