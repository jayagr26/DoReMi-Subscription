package com.example.geektrust.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.config.ConfigProperties;
import com.example.geektrust.entity.Plans.Plan;
import com.example.geektrust.entity.Plans.PlanFactory;

public class SubscriptionTest {

    Subscription subscription;

    @BeforeEach
    public void setup() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("22-03-2022", formatter);
        subscription = new Subscription(date);
    }
    
    @Test
    public void addPlanTest() {
        // Arrange
        String planType = "FREE";
        String categoryType = "MUSIC";
        Plan plan = PlanFactory.getPlan(planType);
        plan.setActiveCategoryType(CategoryType.valueOf(categoryType));
        plan.setDurationInMonths(ConfigProperties.getDuration(planType, categoryType));
        plan.setPriceInRupees(ConfigProperties.getPrice(planType, categoryType));

        // Act
        subscription.addPlan(plan);

        // Assert
        Assertions.assertTrue(subscription.getPlans().contains(plan));
    }   

    @Test
    public void addTopupTest() {
        // Arrange
        String topupName = "FOUR_DEVICE";
        Integer numOfMonths = 2;
        Integer topupPrice = 50;
        Topup topup = new Topup(topupName);
        topup.setNumOfMonths(numOfMonths);
        topup.setTopupPrice(topupPrice);

        // Act
        subscription.addTopup(topup);

        // Assert
        Assertions.assertTrue(subscription.getTopup().equals(topup));
    }

    @Test
    public void RenewalDateTest() {
        // Arrange
        String planType = "FREE";
        String categoryType = "MUSIC";
        Plan plan = PlanFactory.getPlan(planType);
        plan.setActiveCategoryType(CategoryType.valueOf(categoryType));
        plan.setDurationInMonths(ConfigProperties.getDuration(planType, categoryType));
        plan.setPriceInRupees(ConfigProperties.getPrice(planType, categoryType));

        // Set According to StartDate in Test Class setup method
        LocalDate expectedDate = LocalDate.parse("2022-04-12");

        // Act
        LocalDate actualDate = subscription.getRenewalDate(plan);

        // Assert
        Assertions.assertEquals(expectedDate, actualDate);
    }
}
