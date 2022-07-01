package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.config.ConfigProperties;
import com.example.geektrust.entity.Topup;
import com.example.geektrust.services.ISubscriptionService;

public class AddTopupCommand implements ICommand {
    ISubscriptionService service;

    public AddTopupCommand(ISubscriptionService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String topupName = tokens.get(1);
        Integer numOfMonths = Integer.valueOf(tokens.get(2));

        Topup topup = new Topup(topupName);
        topup.setNumOfMonths(numOfMonths);
        topup.setTopupPrice(ConfigProperties.getTopupPrice(topupName));

        service.addTop(topup);
    }
    
}
