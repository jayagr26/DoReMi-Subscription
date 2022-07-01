package com.example.geektrust.entity.Plans;

public class PlanFactory {

    public static Plan getPlan(String planType) {
        if (planType.equals("FREE")) {
            return new FreePlan();
        } else if (planType.equals("PERSONAL")) {
            return new PersonalPlan();
        } else if (planType.equals("PREMIUM")) {
            return new PremiumPlan();
        } else {
            return null;
        }

    }

}
