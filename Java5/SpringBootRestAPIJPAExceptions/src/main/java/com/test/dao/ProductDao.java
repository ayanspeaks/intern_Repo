package com.test.dao;

import java.util.List;
import java.util.Optional;

import com.test.entity.Product;

public interface ProductDao {
	
	public Product createProduct(Product pr);
	
	public List<Product> listAllProducts();
	
	public Optional<Product> getByProductId(int id);
	
	public Product updateProduct(Product pr);
	
	public List<Product> deleteProduct(int id);

}
