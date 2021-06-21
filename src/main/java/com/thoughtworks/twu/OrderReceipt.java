package com.thoughtworks.twu;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class OrderReceipt {
	public static final String ORDER_RECEIPT_HEADER = "======Printing Orders======\n";
	public static final String ORDER_RECEIPT_TOTAL_SALES_TAX = "Sales Tax\t";
	public static final String ORDER_RECEIPT_TOTAL_AMOUNT = "Total Amount\t";
	public static final String ORDER_RECEIPT_DELIVERY_DATE = "Delivery on ";

	private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder(ORDER_RECEIPT_HEADER);

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
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getLineStatement());
			output.append(System.lineSeparator());
		}
		output.append(ORDER_RECEIPT_TOTAL_SALES_TAX).append(order.getTotalSalesTax());
		output.append(System.lineSeparator());

		output.append(ORDER_RECEIPT_TOTAL_AMOUNT).append(order.getTotalAmount());
		output.append(System.lineSeparator());
	}

	private void appendDeliveryInformation(StringBuilder output) {
		ZonedDateTime date = ZonedDateTime.parse(order.deliveryDate);
		String readableDate = date.format(DateTimeFormatter.RFC_1123_DATE_TIME);
		output.append(ORDER_RECEIPT_DELIVERY_DATE).append(readableDate);
	}
}