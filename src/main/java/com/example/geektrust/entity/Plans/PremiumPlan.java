package com.example.geektrust.entity.Plans;

import com.example.geektrust.entity.CategoryType;

import lombok.Data;

@Data
public class PremiumPlan extends Plan {
    private final String planName = "PremiumPlan";

    public PremiumPlan(CategoryType categoryType, Integer months, Integer price) {
        super(months, price, categoryType);
    }

    public PremiumPlan() {
        super();
    }
}
