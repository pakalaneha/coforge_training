package com.coforge.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.pms.model.Product;
import com.coforge.pms.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	private ProductService service;
	private Environment environment;

	@Autowired
	public ProductController(ProductService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/api/v1/pms/products")
	public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product) {
		ResponseEntity<?> responseEntity = null;

			boolean status = service.saveProduct(product);
			if (status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.save.success"), HttpStatus.CREATED);
			}
		
		return responseEntity;
	}

	@DeleteMapping("/api/v1/pms/products/{pid}")
	public ResponseEntity<?> deleteProduct(@PathVariable("pid") int pid) {
		ResponseEntity<?> responseEntity = null;
			boolean status = service.deleteProduct(pid);
			if (status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.delete.success"), HttpStatus.OK);
			}
		return responseEntity;
	}

	@PutMapping("/api/v1/pms/products/{pid}")
	public ResponseEntity<?> updateProduct(@PathVariable("pid") int pid,@Valid @RequestBody Product product) {
		ResponseEntity<?> responseEntity = null;

			boolean status = service.updateProduct(pid, product);
			if (status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.update.success"), HttpStatus.OK);
			}
		
		return responseEntity;
	}

	@GetMapping("/api/v1/pms/products/{pid}")
	public ResponseEntity<?> findProduct(@PathVariable("pid") int pid) {
		ResponseEntity<?> responseEntity = null;
			Optional<Product> product = service.findProduct(pid);
			if (product.isPresent())
				responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK);
		
		
		return responseEntity;
	}

	@GetMapping("/api/v1/pms/products")
	public ResponseEntity<?> findAllProducts() {
		ResponseEntity<?> responseEntity = null;

			List<Product> products = service.findAllProducts();
			products.sort((p1, p2) -> Integer.compare(p1.getPid(), p2.getPid()));
			responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
		
		return responseEntity;
	}

	@GetMapping("/api/v1/pms/products/pname/{pname}")
	public ResponseEntity<?> findProductByPname(@PathVariable("pname") String pname) {
		ResponseEntity<?> responseEntity = null;
		
			List<Product> products = service.findProductByPname(pname);
			responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
		
		return responseEntity;
	}

	@GetMapping("/api/v1/pms/products/price/{price}")
	public ResponseEntity<?> findProductByPrice(@PathVariable("price") int price) {
		ResponseEntity<?> responseEntity = null;
			List<Product> products = service.findProductByPrice(price);
			responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
		
		return responseEntity;
	}

	@GetMapping("/api/v1/pms/products/quantity/{quantity}")
	public ResponseEntity<?> findProductByQuantity(@PathVariable("quantity") int quantity) {
		ResponseEntity<?> responseEntity = null;
			List<Product> products = service.findProductByQuantity(quantity);
			responseEntity = new ResponseEntity<>(products, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping("/api/v1/pms/products/price/{minPrice}/{maxPrice}")
	public ResponseEntity<?> findProductByPriceRange(@PathVariable("minPrice") int minPrice,
			@PathVariable("maxPrice") int maxPrice) {
		ResponseEntity<?> responseEntity = null;
			List<Product> products = service.findProductByPriceRange(minPrice, maxPrice);
			responseEntity = new ResponseEntity<>(products, HttpStatus.OK);

		return responseEntity;
	}

	@DeleteMapping("/api/v1/pms/products/pname/{pname}")
	public ResponseEntity<?> deleteProductByPname(@PathVariable("pname") String pname) {
		ResponseEntity<?> responseEntity = null;
			boolean status = service.deleteProductByPname(pname);
			if (status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.delete.success"), HttpStatus.OK);
			}
		return responseEntity;
	}

	@GetMapping("/api/v1/pms/products/info")
	public ResponseEntity<?> getInfo() {
	    String info = service.getInfo();
	    return new ResponseEntity<>(info, HttpStatus.OK);
	}
}
