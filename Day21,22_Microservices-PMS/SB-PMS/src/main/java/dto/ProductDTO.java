package com.coforge.pms.dto;

import com.coforge.pms.model.Product;

public class ProductDTO {
	
	private Product product;
	
	private SupplierDTO supplierDTO;
	
	
	public ProductDTO(Product product, SupplierDTO supplierDTO) {
		super();
		this.product = product;
		this.supplierDTO = supplierDTO;
	}

	public ProductDTO() {
		super();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SupplierDTO getSupplierDTO() {
		return supplierDTO;
	}

	public void setSupplierDTO(SupplierDTO supplierDTO) {
		this.supplierDTO = supplierDTO;
	}


}
