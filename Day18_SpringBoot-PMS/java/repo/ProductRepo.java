package com.coforge.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coforge.pms.model.Product;

public interface ProductRepo extends CrudRepository<Product, Integer>{
	
	 // Search by Product Name
    List<Product> findByPname(String pname);

    // Delete by Product Name
    int deleteByPname(String pname);

    // Search by Price
    List<Product> findByPrice(int price);

    // Search by Quantity
    List<Product> findByQuantity(int quantity);

    // Search by Price Range
    List<Product> findByPriceBetween(int minPrice, int maxPrice);

    // Count Total Products and Sum of Product Prices
    @Query("select count(*), sum(price) from Product")
    List<Object[]> getInfo();
}
