package com.essential.lv2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class MenuItem{
    public String name;
    private Double price;
    private String description;
}
