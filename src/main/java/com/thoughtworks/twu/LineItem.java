package com.thoughtworks.twu;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

    public String statement() {
		StringBuilder output = new StringBuilder();

		output.append(getDescription()).append('\t');
		output.append(getPrice()).append('\t');
		output.append(getQuantity()).append('\t');
		output.append(totalAmount());

		return output.toString();
	}
}