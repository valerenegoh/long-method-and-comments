# Long Methods and Comments

## Trainee Guide

For this exercise, you are looking to refactor TWO code smells:
* Long Methods
* Comments

Research the code smell and fix it in the code.
Present it back to the team by explaining:
* What are the code smells?
* What is the effect? Why is it bad to leave them?
* How did you fix it? Show us the before and after.

##### Clone the project
```shell
git clone <link to repo>
```

##### Checkout and update the master
```shell
git pull -r
```

##### Create a new branch with TWU Number, Team Number and Pair Name, example:
```shell
git checkout -b refactoring-techniques-<TWU_NUMBER>-<TEAM_NUMBER>-<PAIR_NAME>
```

##### After finishing the exercise, submit your changes
```shell
git fetch origin master && \
git add . && \
git commit -m "WIP - Refactoring Techniques Session" && \
git push origin refactoring-techniques-<TWU_NUMBER>-<TEAM_NUMBER>-<PAIR_NAME> --no-verify
```

## About this Application

This application prints the details of order including customer name, address, description, quantity, price and amount.
It also calculates the sales tax @ 10% and prints as part of order. It computes the total order amount
(amount of individual lineItems + total sales tax) and prints it.

Example output:

```
======Printing Orders======
Mr X
Chicago, 60601
milk	10.0	2	20.0
biscuits	5.0	5	25.0
chocolate	20.0	1	20.0
Sales Tax	6.5
Total Amount	71.5
Delivery on Tue, 31 Dec 2019 23:59:00 GMT
```