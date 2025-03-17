package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ProductDao;
import com.test.entity.Product;

import com.test.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product createProduct(Product pr) {
		return productDao.createProduct(pr);
	}

	@Override
	public List<Product> listAllProducts() {
		return productDao.listAllProducts();
	}

	@Override
	public Optional<Product> getByProductId(int id) {
		return productDao.getByProductId(id);
	}

	@Override
	public Product updateProduct(Product pr) {
		return productDao.updateProduct(pr);
	}

	@Override
	public List<Product> deleteProductById(int id) {
		return productDao.deleteProduct(id);
	}

}
