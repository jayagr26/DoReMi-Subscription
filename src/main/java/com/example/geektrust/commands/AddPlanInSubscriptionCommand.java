package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.config.ConfigProperties;
import com.example.geektrust.entity.CategoryType;
import com.example.geektrust.entity.Plans.Plan;
import com.example.geektrust.entity.Plans.PlanFactory;
import com.example.geektrust.services.ISubscriptionService;

public class AddPlanInSubscriptionCommand implements ICommand {
    private ISubscriptionService service;
    private String planType;
    private String categoryType;

    public AddPlanInSubscriptionCommand(ISubscriptionService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        categoryType = tokens.get(1);
        planType = tokens.get(2);

        Plan plan = PlanFactory.getPlan(planType);
        
        plan.setDurationInMonths(ConfigProperties.getDuration(planType, categoryType));
        plan.setPriceInRupees(ConfigProperties.getPrice(planType, categoryType));
        plan.setActiveCategoryType(CategoryType.valueOf(categoryType));

        service.addPlanInSubscription(plan);
    }

}
