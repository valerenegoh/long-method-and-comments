package com.thoughtworks.twu;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderReceiptTest {

    @Test
    public void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<>(), "2019-12-31T23:59Z");
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertTrue(output.contains("Mr X"));
        assertTrue(output.contains("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        ArrayList<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, "2019-12-31T23:59Z"));

        String output = receipt.printReceipt();

        assertTrue(output.contains("milk\t10.0\t2\t20.0\n"));
        assertTrue(output.contains("biscuits\t5.0\t5\t25.0\n"));
        assertTrue(output.contains("chocolate\t20.0\t1\t20.0\n"));
        assertTrue(output.contains("Sales Tax\t6.5"));
        assertTrue(output.contains("Total Amount\t71.5"));
    }

    @Test
    public void shouldPrintDeliveryInformation() {
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, new ArrayList<>(), "2012-12-31T23:59Z"));

        String output = receipt.printReceipt();

        assertTrue(output.contains("Delivery on Mon, 31 Dec 2012 23:59:00 GMT"));
    }

}
