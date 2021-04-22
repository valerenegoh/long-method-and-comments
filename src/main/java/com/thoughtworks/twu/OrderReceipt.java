package com.thoughtworks.twu;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		// print headers
		output.append("======Printing Orders======\n");

		// print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        output.append(order.getCustomerName());
		output.append(System.lineSeparator());
        output.append(order.getCustomerAddress());
		output.append(System.lineSeparator());
//        output.append(order.getCustomerLoyaltyNumber());

		// prints lineItems
		double totalSalesTax = 0d;
		double total = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription());
			output.append('\t');
			output.append(lineItem.getPrice());
			output.append('\t');
			output.append(lineItem.getQuantity());
			output.append('\t');
			output.append(lineItem.totalAmount());
			output.append(System.lineSeparator());

			// calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            total += lineItem.totalAmount() + salesTax;
		}

		// prints the state tax
		output.append("Sales Tax").append('\t').append(totalSalesTax);
		output.append(System.lineSeparator());

        // print total amount
		output.append("Total Amount").append('\t').append(total);
		output.append(System.lineSeparator());

		ZonedDateTime date = ZonedDateTime.parse(order.deliveryDate);
		String readableDate = date.format(DateTimeFormatter.RFC_1123_DATE_TIME);
		output.append("Delivery on ").append(readableDate);

		return output.toString();
	}
}