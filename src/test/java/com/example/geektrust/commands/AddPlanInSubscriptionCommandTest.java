package com.example.geektrust.commands;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.geektrust.config.ConfigProperties;
import com.example.geektrust.entity.CategoryType;
import com.example.geektrust.entity.Plans.Plan;
import com.example.geektrust.entity.Plans.PlanFactory;
import com.example.geektrust.exceptions.AlreadyExistingSubscriptionException;
import com.example.geektrust.exceptions.InvalidDateException;
import com.example.geektrust.services.ISubscriptionService;

@DisplayName("AddPlanInSubscriptionCommandTest")
@ExtendWith(MockitoExtension.class)
public class AddPlanInSubscriptionCommandTest {
    private final String commandName = "ADD_SUBSCRIPTION";

    @Mock
    ISubscriptionService service;

    @InjectMocks
    AddPlanInSubscriptionCommand addPlanInSubscriptionCommand;

    //  Checking if Properly Throwing Exceptions
    @Test
    @DisplayName("execute method of AddPlanInSubscriptionCommandTest Should Throw Invalid Date Exception")
    public void execute_ShouldThrowInvalidDate() {

        // Arrange
        String planType = "FREE";
        String categoryType = "MUSIC";
        List<String> tokens = new ArrayList<>();
        tokens.add(commandName);
        tokens.add(categoryType);
        tokens.add(planType);

        Plan plan = PlanFactory.getPlan(planType);
        plan.setDurationInMonths(ConfigProperties.getDuration(planType, categoryType));
        plan.setPriceInRupees(ConfigProperties.getPrice(planType, categoryType));
        plan.setActiveCategoryType(CategoryType.valueOf(categoryType));

        doThrow(InvalidDateException.class).when(service).addPlanInSubscription(plan);
        // Act & Assert
        assertThrows(InvalidDateException.class, () -> addPlanInSubscriptionCommand.execute(tokens));
        verify(service, times(1)).addPlanInSubscription(plan);
    }

    @Test
    public void execute_ShouldThrowAlreadyExistingSubscriptionException() {
        // Arrange
        String planType = "FREE";
        String categoryType = "MUSIC";
        List<String> tokens = new ArrayList<>();
        tokens.add(commandName);
        tokens.add(categoryType);
        tokens.add(planType);

        Plan plan = PlanFactory.getPlan(planType);
        plan.setDurationInMonths(ConfigProperties.getDuration(planType, categoryType));
        plan.setPriceInRupees(ConfigProperties.getPrice(planType, categoryType));
        plan.setActiveCategoryType(CategoryType.valueOf(categoryType));

        doThrow(AlreadyExistingSubscriptionException.class).when(service).addPlanInSubscription(plan);

        // Act & Assert
        Assertions.assertThrows(AlreadyExistingSubscriptionException.class, () -> addPlanInSubscriptionCommand.execute(tokens));
        verify(service, times(1)).addPlanInSubscription(plan);
    }

}
