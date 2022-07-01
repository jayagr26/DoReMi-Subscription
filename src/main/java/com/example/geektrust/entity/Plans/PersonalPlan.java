package com.example.geektrust.entity.Plans;

import com.example.geektrust.entity.CategoryType;

import lombok.Data;

@Data
public class PersonalPlan extends Plan {
    private final String planName = "PersonalPlan";

    public PersonalPlan(CategoryType categoryType, Integer months, Integer price) {
        super(months, price, categoryType);
    }

    public PersonalPlan() {
        super();
    }
}
