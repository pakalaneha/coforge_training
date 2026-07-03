package com.coforge.day3;

public class Mobile {

	private String Brand;
	private String Model;
	private String RAM;
	private int Price;

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getRAM() {
		return RAM;
	}

	public void setRAM(String rAM) {
		RAM = rAM;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Mobile [Brand=" + Brand + ", Model=" + Model + ", RAM=" + RAM + ", Price=" + Price + "]";
	}

}
