package com.example.geektrust.services;

import java.time.LocalDate;

import com.example.geektrust.entity.Topup;
import com.example.geektrust.entity.Plans.Plan;

public interface ISubscriptionService {
    public void startSubscription(LocalDate date);

    public void addPlanInSubscription(Plan plan);

    public void printRenewDetails();

    public void addTop(Topup topup);
}
