package com.example.Ecommerce.service;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;

import com.example.Ecommerce.entity.Product;



public interface ProductService {
	public List<Product> findAll();
	public Product findById(Integer id);
	public void saveOrUpdate(Producer product);
	public void deleteById(Integer id);
	void saveOrUpdate(Product product);
}

