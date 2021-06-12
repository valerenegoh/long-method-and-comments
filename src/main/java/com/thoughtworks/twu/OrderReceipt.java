package com.thoughtworks.twu;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append("======Printing Orders======\n");

		appendCustomerInformation(output);
		appendLineItemsAndSalesTax(output);
		appendDeliveryInformation(output);

		return output.toString();
	}

	private void appendCustomerInformation(StringBuilder output) {
		output.append(order.getCustomerName());
		output.append(System.lineSeparator());
		output.append(order.getCustomerAddress());
		output.append(System.lineSeparator());
	}

	private void appendLineItemsAndSalesTax(StringBuilder output) {
		double totalSalesTax = 0d;
		double total = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription()).append('\t');
			output.append(lineItem.getPrice()).append('\t');
			output.append(lineItem.getQuantity()).append('\t');
			output.append(lineItem.totalAmount());
			output.append(System.lineSeparator());

			double salesTax = calculate10PctSalesTax(lineItem);
			totalSalesTax += salesTax;
			total += lineItem.totalAmount() + salesTax;
		}
		output.append("Sales Tax").append('\t').append(totalSalesTax);
		output.append(System.lineSeparator());

		output.append("Total Amount").append('\t').append(total);
		output.append(System.lineSeparator());
	}

	private void appendDeliveryInformation(StringBuilder output) {
		ZonedDateTime date = ZonedDateTime.parse(order.deliveryDate);
		String readableDate = date.format(DateTimeFormatter.RFC_1123_DATE_TIME);
		output.append("Delivery on ").append(readableDate);
	}

	private double calculate10PctSalesTax(LineItem lineItem) {
    	return lineItem.totalAmount() * .10;
	}
}