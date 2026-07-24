package com.coforge.pms.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SupplierDTO {

	private int supplierId;

	private String supplierName;

	private String city;

	public SupplierDTO() {
		super();
	}

	public SupplierDTO(@NotNull @Positive int supplierId, @NotNull String supplierName, @NotNull String city) {
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
