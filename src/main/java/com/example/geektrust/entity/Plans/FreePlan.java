package com.example.geektrust.entity.Plans;

import com.example.geektrust.entity.CategoryType;

import lombok.Data;

@Data
public class FreePlan extends Plan {
    private final String planName = "FreePlan";

    public FreePlan(CategoryType categoryType, Integer months, Integer price) {
        super(months, price, categoryType);
    }

    public FreePlan() {
        super();
    }
}
