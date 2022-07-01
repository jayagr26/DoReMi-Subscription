package com.example.geektrust.entity.Plans;

import java.util.ArrayList;
import java.util.List;

import com.example.geektrust.entity.CategoryType;
import com.example.geektrust.exceptions.AlreadyExistingSupportForCategoryException;

import lombok.Data;

@Data
public class Plan {
    private Integer durationInMonths;
    private Integer priceInRupees;
    private CategoryType activeCategoryType;

    private List<CategoryType> supportedCategoryTypes = new ArrayList<CategoryType>() {
        {
            add(CategoryType.MUSIC);
            add(CategoryType.VIDEO);
            add(CategoryType.PODCAST);
        }
    };

    public Plan() {

    }

    public Plan(Integer months, Integer price, CategoryType activeCategoryType) {
        durationInMonths = months;
        priceInRupees = price;
        this.activeCategoryType = activeCategoryType;
    }

    public void addCategorySupport(CategoryType categoryType) throws AlreadyExistingSupportForCategoryException {
        if (supportedCategoryTypes.contains(categoryType)) {
            throw new AlreadyExistingSupportForCategoryException();
        }
        supportedCategoryTypes.add(categoryType);
    }

    public void removeCategorySupport(CategoryType categoryType) {
        if (supportedCategoryTypes.contains(categoryType)) {
            supportedCategoryTypes.remove(categoryType);
        }
    }

    public boolean hasCategorySupport(CategoryType categoryType) {
        return supportedCategoryTypes.contains(categoryType);
    }
}
