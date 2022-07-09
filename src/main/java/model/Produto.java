package model;

import java.util.ArrayList;

public class Produto {
	private String productName;
	private String description;
	private ArrayList<String> targetMarket;
	private ArrayList<String> stack;
	
	public Produto() {
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getTargetMarket() {
		return targetMarket;
	}

	public void setTargetMarket(ArrayList<String> targetMarket) {
		this.targetMarket = targetMarket;
	}

	public ArrayList<String> getStack() {
		return stack;
	}

	public void setStack(ArrayList<String> stack) {
		this.stack = stack;
	}

	@Override
	public String toString() {
		return "Produto [productName=" + productName + ", description=" + description + ", targetMarket=" + targetMarket
				+ ", stack=" + stack + "]";
	}
	
	
	
	
	

}
