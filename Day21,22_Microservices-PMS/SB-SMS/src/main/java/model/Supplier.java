package com.coforge.sms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tbl_supplier")
public class Supplier {

	@Id
	@Column(name = "supplierId")
	@NotNull
	@Positive
	private int supplierId;

	@Column(name = "supplierName")
	@NotNull
	private String supplierName;

	@Column(name = "city")
	@NotNull
	private String city;

	public Supplier() {
		super();
	}

	public Supplier(@NotNull @Positive int supplierId, @NotNull String supplierName, @NotNull String city) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.city = city;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", city=" + city + "]";
	}

}
