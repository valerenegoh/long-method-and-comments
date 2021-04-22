package com.thoughtworks.twu;

import java.util.List;

public class Order {
    String name;
    String address;
    List<LineItem> lineItems;
    String deliveryDate;

    public Order(String name, String address, List<LineItem> lineItems, String deliveryDate) {
        this.name = name;
        this.address = address;
        this.lineItems = lineItems;
        this.deliveryDate = deliveryDate;
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
}
