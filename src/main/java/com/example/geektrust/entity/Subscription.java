package com.example.geektrust.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.geektrust.entity.Plans.Plan;
import com.example.geektrust.exceptions.AlreadyExistingSubscriptionException;
import com.example.geektrust.exceptions.AlreadyExistingTopupException;

import lombok.Data;

@Data
public class Subscription {
    private LocalDate startDate = null;
    private List<Plan> plans;
    private Topup topup;

    private final int DAYS_BEFORE_RENEWAL_REMINDER_TO_BE_SENT = 10;

    public Subscription(LocalDate startDate) {
        this.startDate = startDate;
        plans = new ArrayList<Plan>();
    }

    public void addPlan(Plan plan) throws AlreadyExistingSubscriptionException {
        for (Plan planInList : plans) {
            if (planInList.getActiveCategoryType() == plan.getActiveCategoryType()) {
                throw new AlreadyExistingSubscriptionException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
            }
        }
        plans.add(plan);
    } 

    public LocalDate getRenewalDate(Plan plan) {
        LocalDate date = startDate.plusMonths(plan.getDurationInMonths())
                .minusDays(DAYS_BEFORE_RENEWAL_REMINDER_TO_BE_SENT);
        return date;
    }

    public void addTopup(Topup topup) throws AlreadyExistingTopupException {
        if (this.topup == null) {
            this.topup = topup;
        } else {
            throw new AlreadyExistingTopupException("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
        }
    }
}
