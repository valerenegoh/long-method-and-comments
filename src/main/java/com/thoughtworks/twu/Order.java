package com.thoughtworks.twu;

import java.util.List;

public class Order {
    public static final double SALES_TAX_RATE = .10;

    String name;
    String address;
    List<LineItem> lineItems;
    String deliveryDate;
    double totalSalesTax;
    double totalAmount;

    public Order(String name, String address, List<LineItem> lineItems, String deliveryDate) {
        this.name = name;
        this.address = address;
        this.lineItems = lineItems;
        this.deliveryDate = deliveryDate;
        calculateTotals();
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void calculateTotals() {
        for (LineItem lineItem : lineItems) {
            double salesTax = lineItem.totalAmount() * SALES_TAX_RATE;
            totalSalesTax += salesTax;
            totalAmount += lineItem.totalAmount() + salesTax;
        }
    }
}
