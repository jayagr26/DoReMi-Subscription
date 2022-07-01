# [DoReMi Subscription](https://www.geektrust.com/coding/detailed/doremi-subscription) 

## Problem Statement
### Context
 DoReMi is a streaming app which allows users to listen to music, podcasts and watch videos. They offer different subscription plans for different categories of services. Users can subscribe to any of these plans. 
 
 - A user can choose only one plan per category. 
 - All plans, by default, can only be streamed on one device. 
 
 #### Music streaming subscription plans 
 
| FREE	| PERSONAL | PREMIUM |
|-------|----------|---------|
| 1 month Trial |	Rs.100 for 1 month | Rs. 250 for 3 months |

 #### Video streaming subscription plans 
 
| FREE	| PERSONAL | PREMIUM |
|-------|----------|---------|
| 1 month Trial |	Rs.200 for 1 month | Rs. 500 for 3 months |

 #### Podcast streaming subscription plans 
 
| FREE	| PERSONAL | PREMIUM |
|-------|----------|---------|
| 1 month Trial |	Rs.100 for 1 month | Rs. 300 for 3 months |

#### Top Up

 DoReMi allows users to add a top up to increase the number of devices that they can stream to for an additional cost.
 - A user can choose only one top up.  
 - The subscribed top up is applicable for all subscriptions. 
 - A top up can be added only when a subscription exists.
 
| FOUR_DEVICE | TEN_DEVICE | 
|-------------|------------|
| Upto 4 Devices | Upto 10 Devices |
| Total cost: Rs.50 for 1 month | Total cost: Rs.100 for 1 month |

#### Renewal Reminder
 Once a user subscribes to a plan, the user needs to be notified 10 days before the plan expires. 
 
### Goal
 Given a date when the subscription starts, your program should print: 
 
 - The date on which the reminder should be sent for each subscription category 
 - The total amount for renewal. Renewal amount is the sum of all the subscription plan amount and top up amount. 

#### Assumptions
 - A user can buy only one category of subscription at a time. 
 - By default all plans can only be streamed on one device 
 - A user can buy only one category of top up at a time. 
 - One top up applies to all the subscriptions being bought. 
