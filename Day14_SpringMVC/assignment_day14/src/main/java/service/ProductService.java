package com.coforge.pms.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coforge.pms.model.Product;



@Service
public class ProductService {
	private HashMap<Integer, Product> map = new HashMap<>();

	public boolean createProduct(Product product) { 
		// TODO Auto-generated method stub
		if(!map.containsKey(product.getPid())) {
			map.put(product.getPid(),product);
			return true;
		}
		return false;
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub

		if(!map.containsKey(product.getPid())) {
			return false;
		}
		else {
			map.put(product.getPid(), product);
			return true;
		}
	}

	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub
		//boolean status = false;
		if(!map.containsKey(pid)) {
			return false;
		}
		else {
			map.remove(pid);
			return true;
		}
	}

	public Product findProduct(int pid) {
		// TODO Auto-generated method stub
		if(!map.containsKey(pid)) {
			return null;
		}
		else {
			return map.get(pid);
		}
	}

	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
		for(Integer x : map.keySet()) {
			products.add(map.get(x));
		}
		return products;
	}
}
