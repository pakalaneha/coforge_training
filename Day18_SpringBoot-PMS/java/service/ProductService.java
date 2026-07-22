package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.pms.exception.InvalidProductObjectException;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;

public interface ProductService {

	public boolean saveProduct(Product product);

	public boolean deleteProduct(int pid);

	public boolean updateProduct(int pid, Product product);

	public Optional<Product> findProduct(int pid);

	public List<Product> findAllProducts();

	public List<Product> findProductByPname(String pname);

	public boolean deleteProductByPname(String pname);

	// Search by Price
	public List<Product> findProductByPrice(int price);

	// Search by Quantity
	public List<Product> findProductByQuantity(int quantity);

	// Search by Price Range
	public List<Product> findProductByPriceRange(int minPrice, int maxPrice);

	// Count Total Products and Sum of Product Prices
	public String getInfo();

}
