package com.example.geektrust.commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.geektrust.exceptions.InvalidDateException;
import com.example.geektrust.services.ISubscriptionService;

public class StartSubscriptionCommand implements ICommand {
    private ISubscriptionService service;
    private String date;

    public StartSubscriptionCommand(ISubscriptionService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) throws InvalidDateException {
        // TODO Auto-generated method stub
        date = tokens.get(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // convert String to LocalDate
        LocalDate startDate;
        try {
            startDate = LocalDate.parse(date, formatter);
        } catch (Exception e) {
            throw new InvalidDateException("INVALID_DATE");
        }
        service.startSubscription(startDate);
    }
}
