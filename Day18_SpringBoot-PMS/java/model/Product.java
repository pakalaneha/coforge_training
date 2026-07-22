package com.coforge.pms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name = "pid")
	private int pid;
	
	@Column(name = "pname", length=30)
	@NotBlank(message = "Product name cannot be empty")
	private String pname;
	
	@Column(name = "price")
	@Positive(message = "Price should be greater than zero")
	private int price;
	
	@Column(name = "quantity")
	@Positive(message = "Quantity should be greater than zero")
	private int quantity;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, String pname, int price, int quantity) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
