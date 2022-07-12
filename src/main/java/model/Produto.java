package model;

import java.util.ArrayList;

public class Produto {
	private String productName;
	private String description;
	private ArrayList<String> targetMarket; 
	private ArrayList<Tecnologia> stack;

	public Produto() {
		targetMarket = new ArrayList<String>();
		stack = new ArrayList<Tecnologia>();
		
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
	public ArrayList<Tecnologia> getStack() {
		return stack;
	}
	public void setStack(ArrayList<Tecnologia> stack) {
		this.stack = stack;
	} 
	
	public boolean hasAnyCheckedTechnology() {
		for (Tecnologia tec: this.getStack()) {
			if (tec.isChecked()) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
