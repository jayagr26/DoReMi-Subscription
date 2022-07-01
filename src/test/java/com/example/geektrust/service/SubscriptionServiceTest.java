package com.example.geektrust.service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.config.ConfigProperties;
import com.example.geektrust.entity.CategoryType;
import com.example.geektrust.entity.Topup;
import com.example.geektrust.entity.Plans.Plan;
import com.example.geektrust.entity.Plans.PlanFactory;
import com.example.geektrust.services.ISubscriptionService;
import com.example.geektrust.services.SubscriptionService;

@DisplayName("SubscriptionServiceTest")
public class SubscriptionServiceTest {
    private ISubscriptionService subscriptionService;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("20-02-2022", formatter);
        subscriptionService = new SubscriptionService();
        subscriptionService.startSubscription(date);
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    
    @Test
    @DisplayName("addPlan method should add plan in the list of plans")
    public void addPlanInSubscriptionTest() {
        // Arrange
        String planType = "FREE";
        String categoryType = "MUSIC";
        
        Plan plan = PlanFactory.getPlan(planType);
        plan.setDurationInMonths(ConfigProperties.getDuration(planType, categoryType));
        plan.setPriceInRupees(ConfigProperties.getPrice(planType, categoryType));
        plan.setActiveCategoryType(CategoryType.valueOf(categoryType));

        // Act
        subscriptionService.addPlanInSubscription(plan);

        // Assert
        Assertions.assertTrue(((SubscriptionService) subscriptionService).getSubscription().getPlans().contains(plan));
    }

    @Test
    @DisplayName("addtopup method should add topup in Subscription")
    public void addTopupInSubscriptionTest() {
        // Arrange
        String topupName = "FOUR_DEVICE";
        Integer topupPrice = 100;
        Integer topupNumOfMonths = 2;

        Topup topup = new Topup(topupName);
        topup.setNumOfMonths(topupNumOfMonths);
        topup.setTopupPrice(topupPrice);

        String planType = "FREE";
        String categoryType = "MUSIC";

        Plan plan = PlanFactory.getPlan(planType);
        plan.setDurationInMonths(ConfigProperties.getDuration(planType, categoryType));
        plan.setPriceInRupees(ConfigProperties.getPrice(planType, categoryType));
        plan.setActiveCategoryType(CategoryType.valueOf(categoryType));
        subscriptionService.addPlanInSubscription(plan);

        // Act
        subscriptionService.addTop(topup);

        // Assert
        Assertions.assertTrue(((SubscriptionService) subscriptionService).getSubscription().getTopup().equals(topup));
    }

    @Test
    public void shouldPrintRenewalDetails() {
        // Arrange
        String expectedOutput = "RENEWAL_REMINDER MUSIC 10-03-2022\nRENEWAL_REMINDER VIDEO 10-05-2022\nRENEWAL_AMOUNT 500";
        String planType1 = "FREE";
        String categoryType1 = "MUSIC";

        Plan plan1 = PlanFactory.getPlan(planType1);
        plan1.setDurationInMonths(ConfigProperties.getDuration(planType1, categoryType1));
        plan1.setPriceInRupees(ConfigProperties.getPrice(planType1, categoryType1));
        plan1.setActiveCategoryType(CategoryType.valueOf(categoryType1));
        subscriptionService.addPlanInSubscription(plan1);

        String planType2 = "PREMIUM";
        String categoryType2 = "VIDEO";

        Plan plan2 = PlanFactory.getPlan(planType2);
        plan2.setDurationInMonths(ConfigProperties.getDuration(planType2, categoryType2));
        plan2.setPriceInRupees(ConfigProperties.getPrice(planType2, categoryType2));
        plan2.setActiveCategoryType(CategoryType.valueOf(categoryType2));
        subscriptionService.addPlanInSubscription(plan2);

        // Act
        subscriptionService.printRenewDetails();

        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

}
