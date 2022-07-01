package com.example.geektrust.commands;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.geektrust.exceptions.InvalidDateException;
import com.example.geektrust.services.ISubscriptionService;

@DisplayName("StartSubscriptionCommandTest")
@ExtendWith(MockitoExtension.class)
public class StartSubscriptionCommandTest {
    private final String commandName = "START_SUBSCRIPTION";
    @Mock
    ISubscriptionService service;

    @InjectMocks
    StartSubscriptionCommand startSubscriptionCommand;

    @Test
    @DisplayName("execute method of StartSubscriptionCommandTest on Invalid Date should throw exception")
    public void execute_ShouldCreateThrowException() {
        
        // Arrange
        String date = "17-19-22";
        List<String> tokens = new ArrayList<String>();
        tokens.add(commandName);
        tokens.add(date);

        // Act & Assert
        Assertions.assertThrows(InvalidDateException.class, () -> startSubscriptionCommand.execute(tokens));
        verify(service, times(0)).startSubscription(any());

    }

}
