package com.example.geektrust.config;

import com.example.geektrust.commands.AddPlanInSubscriptionCommand;
import com.example.geektrust.commands.AddTopupCommand;
import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.commands.PrintRenewalDetailsCommand;
import com.example.geektrust.commands.StartSubscriptionCommand;
import com.example.geektrust.services.ISubscriptionService;
import com.example.geektrust.services.SubscriptionService;

public class ConfigProperties {

    private final CommandInvoker commandInvoker = new CommandInvoker();
    private final ISubscriptionService service = new SubscriptionService();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.register("START_SUBSCRIPTION", new StartSubscriptionCommand(service));
        commandInvoker.register("ADD_SUBSCRIPTION", new AddPlanInSubscriptionCommand(service));
        commandInvoker.register("ADD_TOPUP", new AddTopupCommand(service));
        commandInvoker.register("PRINT_RENEWAL_DETAILS", new PrintRenewalDetailsCommand(service));
        return commandInvoker;
    }

    public static Integer getDuration(String planType, String catogoryType) {
        Integer FREE_MUSIC_PLAN_DURATION_IN_MONTHS = 1;
        Integer PERSONAL_MUSIC_PLAN_DURATION_IN_MONTHS = 1;
        Integer PREMIUM_MUSIC_PLAN_DURATION_IN_MONTHS = 3;
        Integer FREE_VIDEO_PLAN_DURATION_IN_MONTHS = 1;
        Integer PERSONAL_VIDEO_PLAN_DURATION_IN_MONTHS = 1;
        Integer PREMIUM_VIDEO_PLAN_DURATION_IN_MONTHS = 3;
        Integer FREE_PODCAST_PLAN_DURATION_IN_MONTHS = 1;
        Integer PERSONAL_PODCAST_PLAN_DURATION_IN_MONTHS = 1;
        Integer PREMIUM_PODCAST_PLAN_DURATION_IN_MONTHS = 3;

        if (planType.equals("FREE") && catogoryType.equals("MUSIC")) {
            return FREE_MUSIC_PLAN_DURATION_IN_MONTHS;
        } else if (planType.equals("FREE") && catogoryType.equals("VIDEO")) {
            return FREE_VIDEO_PLAN_DURATION_IN_MONTHS;
        } else if (planType.equals("FREE") && catogoryType.equals("PODCAST")) {
            return FREE_PODCAST_PLAN_DURATION_IN_MONTHS;
        } else if (planType.equals("PERSONAL") && catogoryType.equals("MUSIC")) {
            return PERSONAL_MUSIC_PLAN_DURATION_IN_MONTHS;
        } else if (planType.equals("PERSONAL") && catogoryType.equals("VIDEO")) {
            return PERSONAL_VIDEO_PLAN_DURATION_IN_MONTHS;
        } else if (planType.equals("PERSONAL") && catogoryType.equals("PODCAST")) {
            return PERSONAL_PODCAST_PLAN_DURATION_IN_MONTHS;
        } else if (planType.equals("PREMIUM") && catogoryType.equals("MUSIC")) {
            return PREMIUM_MUSIC_PLAN_DURATION_IN_MONTHS;
        } else if (planType.equals("PREMIUM") && catogoryType.equals("VIDEO")) {
            return PREMIUM_VIDEO_PLAN_DURATION_IN_MONTHS;
        } else if (planType.equals("PREMIUM") && catogoryType.equals("PODCAST")) {
            return PREMIUM_PODCAST_PLAN_DURATION_IN_MONTHS;
        }
        return Integer.valueOf(0);
    }

    public static Integer getPrice(String planType, String catogoryType) {
        Integer FREE_MUSIC_PLAN_PRICE_IN_RUPESS = 0;
        Integer PERSONAL_MUSIC_PLAN_PRICE_IN_RUPESS = 100;
        Integer PREMIUM_MUSIC_PLAN_PRICE_IN_RUPESS = 250;
        Integer FREE_VIDEO_PLAN_PRICE_IN_RUPESS = 0;
        Integer PERSONAL_VIDEO_PLAN_PRICE_IN_RUPESS = 200;
        Integer PREMIUM_VIDEO_PLAN_PRICE_IN_RUPESS = 500;
        Integer FREE_PODCAST_PLAN_PRICE_IN_RUPESS = 0;
        Integer PERSONAL_PODCAST_PLAN_PRICE_IN_RUPESS = 100;
        Integer PREMIUM_PODCAST_PLAN_PRICE_IN_RUPESS = 300;

        if (planType.equals("FREE") && catogoryType.equals("MUSIC")) {
            return FREE_MUSIC_PLAN_PRICE_IN_RUPESS;
        } else if (planType.equals("FREE") && catogoryType.equals("VIDEO")) {
            return FREE_VIDEO_PLAN_PRICE_IN_RUPESS;
        } else if (planType.equals("FREE") && catogoryType.equals("PODCAST")) {
            return FREE_PODCAST_PLAN_PRICE_IN_RUPESS;
        } else if (planType.equals("PERSONAL") && catogoryType.equals("MUSIC")) {
            return PERSONAL_MUSIC_PLAN_PRICE_IN_RUPESS;
        } else if (planType.equals("PERSONAL") && catogoryType.equals("VIDEO")) {
            return PERSONAL_VIDEO_PLAN_PRICE_IN_RUPESS;
        } else if (planType.equals("PERSONAL") && catogoryType.equals("PODCAST")) {
            return PERSONAL_PODCAST_PLAN_PRICE_IN_RUPESS;
        } else if (planType.equals("PREMIUM") && catogoryType.equals("MUSIC")) {
            return PREMIUM_MUSIC_PLAN_PRICE_IN_RUPESS;
        } else if (planType.equals("PREMIUM") && catogoryType.equals("VIDEO")) {
            return PREMIUM_VIDEO_PLAN_PRICE_IN_RUPESS;
        } else if (planType.equals("PREMIUM") && catogoryType.equals("PODCAST")) {
            return PREMIUM_PODCAST_PLAN_PRICE_IN_RUPESS;
        }
        return Integer.valueOf(0);
    }

    public static Integer getTopupPrice(String topupName) {

        Integer TOPUP_FOUR_DEVICE_PRICE_IN_RUPEES = 50;
        Integer TOPUP_TEN_DEVICE_PRICE_IN_RUPEES = 100;

        if (topupName.equals("FOUR_DEVICE")) {
            return TOPUP_FOUR_DEVICE_PRICE_IN_RUPEES;
        } else if (topupName.equals("TEN_DEVICE")) {
            return TOPUP_TEN_DEVICE_PRICE_IN_RUPEES;
        }
        return Integer.valueOf(0);
    }
}
