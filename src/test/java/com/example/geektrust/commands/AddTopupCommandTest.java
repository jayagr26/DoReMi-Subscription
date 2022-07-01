package com.example.geektrust.commands;

import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.geektrust.config.ConfigProperties;
import com.example.geektrust.entity.Topup;
import com.example.geektrust.exceptions.AlreadyExistingTopupException;
import com.example.geektrust.exceptions.InvalidDateException;
import com.example.geektrust.services.ISubscriptionService;

@ExtendWith(MockitoExtension.class)
public class AddTopupCommandTest {
    private final String commandName = "ADD_TOPUP";
    @Mock
    ISubscriptionService service;

    @InjectMocks
    AddTopupCommand addTopupCommand;

    @Test
    public void execute_ShouldThrowInvalidDateException() {
        // Arrange
        String topupName = "FOUR_DEVICE";
        Integer numOfMonths = 2;
        List<String> tokens = new ArrayList<>();
        tokens.add(commandName);
        tokens.add(topupName);
        tokens.add(numOfMonths.toString());
        Topup topup = new Topup(topupName);
        topup.setNumOfMonths(numOfMonths);
        topup.setTopupPrice(ConfigProperties.getTopupPrice(topupName));

        doThrow(InvalidDateException.class).when(service).addTop(topup);

        // Act & Assert
        Assertions.assertThrows(InvalidDateException.class, () -> addTopupCommand.execute(tokens));
    }

    @Test
    public void execute_ShouldThrowAlreadyExistingTopupException() {
        String topupName = "FOUR_DEVICE";
        Integer numOfMonths = 2;
        List<String> tokens = new ArrayList<>();
        tokens.add(commandName);
        tokens.add(topupName);
        tokens.add(numOfMonths.toString());
        Topup topup = new Topup(topupName);
        topup.setNumOfMonths(numOfMonths);
        topup.setTopupPrice(ConfigProperties.getTopupPrice(topupName));

        doThrow(AlreadyExistingTopupException.class).when(service).addTop(topup);

        // Act & Assert
        Assertions.assertThrows(AlreadyExistingTopupException.class, () -> addTopupCommand.execute(tokens));
    }
}
