package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.pms.dto.SupplierDTO;
import com.coforge.pms.exception.InvalidProductObjectException;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.repo.ProductRepo;
import com.coforge.pms.service.client.SupplierClient;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepo repo;
	private Environment environment;
	private SupplierClient client;
	
	@Autowired
	public ProductServiceImpl(ProductRepo repo, Environment environment, SupplierClient client) {
	    this.repo = repo;
	    this.environment = environment;
	    this.client = client;
	}

	@Override
	public boolean saveProduct(Product product) {
		
		repo.save(product);
			return true;
	}

	@Override
	public boolean deleteProduct(int pid) {
			if (!repo.existsById(pid)) {
				throw new ProductNotFoundException(environment.getProperty("pms.invalid.not-found"));
			}
			repo.deleteById(pid);
			return true;
	}

	@Override
	public boolean updateProduct(int pid, Product product) {

			Optional<Product> optional = repo.findById(pid);

			if (optional.isEmpty()) {
				throw new ProductNotFoundException(environment.getProperty("pms.invalid.not-found"));
			}

			Product p = optional.get();
			p.setPname(product.getPname());
			p.setPrice(product.getPrice());
			p.setQuantity(product.getQuantity());

			repo.save(p);
			return true;
	}

	@Override
	public Optional<Product> findProduct(int pid){
		Optional<Product> product = repo.findById(pid);
		if (product.isEmpty()) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.not-found"));
		}
		return product;
	}

	@Override
	public List<Product> findAllProducts() {

	    List<Product> products = (List<Product>) repo.findAll();

	    if (products.isEmpty()) {
	        throw new ProductNotFoundException(
	                environment.getProperty("pms.invalid.not-found"));
	    }

	    return products;
	}

	@Override
	public List<Product> findProductByPname(String pname) {
		List<Product> products = repo.findByPname(pname);

	    if (products.isEmpty()) {
	        throw new ProductNotFoundException(
	                environment.getProperty("pms.invalid.not-found"));
	    }

	    return products;
	}

	@Override
	public List<Product> findProductByPrice(int price){
		 List<Product> products = repo.findByPrice(price);

		    if (products.isEmpty()) {
		        throw new ProductNotFoundException(
		                environment.getProperty("pms.invalid.not-found"));
		    }

		    return products;
	}

	@Override
	public List<Product> findProductByQuantity(int quantity) {

	    List<Product> products = repo.findByQuantity(quantity);

	    if (products.isEmpty()) {
	        throw new ProductNotFoundException(
	                environment.getProperty("pms.invalid.not-found"));
	    }

	    return products;
	}

	@Override
	public List<Product> findProductByPriceRange(int minPrice, int maxPrice) {

	    List<Product> products = repo.findByPriceBetween(minPrice, maxPrice);

	    if (products.isEmpty()) {
	        throw new ProductNotFoundException(
	                environment.getProperty("pms.invalid.not-found"));
	    }

	    return products;
	}

	@Override
	@Transactional
	public boolean deleteProductByPname(String pname){

	    int n = repo.deleteByPname(pname);

	    if (n == 0) {
	        throw new ProductNotFoundException(
	                environment.getProperty("pms.invalid.not-found"));
	    }

	    return true;
	}

	@Override
	public String getInfo() {

	    List<Object[]> list = repo.getInfo();
	    Object[] info = list.get(0);

	    long totalProducts = (Long) info[0];
	    Object totalPrice = (info[1] == null) ? 0 : info[1];

	    return "Total Products : " + totalProducts +
	           ", Total Price : " + totalPrice;
	}

	@Override
	public SupplierDTO findSupplierById(int supplierId) {
		SupplierDTO supplier = client.findSupplierById(supplierId);
		return supplier;
	}

	@Override
	public List<SupplierDTO> findSupplierDetails() {
		List<SupplierDTO> suppliers = client.findAllSuppliers();
		return suppliers;
	}

}
