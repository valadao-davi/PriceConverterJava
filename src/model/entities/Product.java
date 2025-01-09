package model.entities;

public class Product {
	private String name;
	private double unitPrice;
	private int quantity;
	
	public Product(String name, double unitPrice, int quantity) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public double calculatePrice() {
		return this.quantity * this.unitPrice;
	}
	
	@Override
	public String toString() {
		return "Product: " + name + 
				" Price: $" + unitPrice +
				" Quantity: " + quantity;
	}
	
	
}
