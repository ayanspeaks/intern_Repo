package com.test.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product createProduct(Product pr) {
		return repository.save(pr);
	}

	@Override
	public List<Product> listAllProducts() {
		return repository.findAll();
	}

	@Override
	public Optional<Product> getByProductId(int id) {
		return repository.findById(id);
	}

	@Override
	public Product updateProduct(Product pr) {
		return repository.save(pr);
	}

	@Override
	public List<Product> deleteProduct(int id) {
		repository.deleteById(id);
		
		return repository.findAll();
	}
	

}
