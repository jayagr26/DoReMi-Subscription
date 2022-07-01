package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.ISubscriptionService;

public class PrintRenewalDetailsCommand implements ICommand {
    ISubscriptionService service;

    public PrintRenewalDetailsCommand(ISubscriptionService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        service.printRenewDetails();
    }

}
