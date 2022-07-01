package com.example.geektrust.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.geektrust.entity.Subscription;
import com.example.geektrust.entity.Topup;
import com.example.geektrust.entity.Plans.Plan;
import com.example.geektrust.exceptions.InvalidDateException;
import com.example.geektrust.exceptions.NoActiveSubscription;

import lombok.Data;

@Data
public class SubscriptionService implements ISubscriptionService {

    private Subscription subscription = null;

    public void startSubscription(LocalDate date) {
        subscription = new Subscription(date);
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void addPlanInSubscription(Plan plan) {
        if (subscription == null ||subscription.getStartDate() == null) {
            throw new InvalidDateException("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        }
        subscription.addPlan(plan);
    }

    public void printRenewDetails() {
        if (subscription == null || subscription.getStartDate() == null || subscription.getPlans().isEmpty()) {
            throw new NoActiveSubscription("SUBSCRIPTIONS_NOT_FOUND");
        }
        Integer sum = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (Plan plan : subscription.getPlans()) {
            LocalDate renewalDate = subscription.getRenewalDate(plan);
            System.out.println("RENEWAL_REMINDER " + plan.getActiveCategoryType() + " " + renewalDate.format(formatter));
            sum += plan.getPriceInRupees();
        }

        if (subscription.getTopup() != null) {
            sum += subscription.getTopup().getNumOfMonths() * subscription.getTopup().getTopupPrice();
        }
        System.out.println("RENEWAL_AMOUNT " + sum);
    }

    public void addTop(Topup topup) {
        if (subscription ==  null || subscription.getStartDate() == null) {
            throw new InvalidDateException("ADD_TOPUP_FAILED INVALID_DATE");
        }
        if (subscription.getPlans().isEmpty()) {
            throw new NoActiveSubscription("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
        }
        subscription.addTopup(topup);
    }
}
