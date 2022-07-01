package com.example.geektrust.entity;

import lombok.Data;

@Data
public class Topup {
    private String topupName;
    private Integer topupPrice;
    private Integer numOfMonths;

    public Topup(String name) {
        topupName = name;
    }
}
