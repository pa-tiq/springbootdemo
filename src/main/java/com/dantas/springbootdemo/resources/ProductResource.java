package com.dantas.springbootdemo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dantas.springbootdemo.entities.Product;
import com.dantas.springbootdemo.repositories.ProductRepository;

@RestController 
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductRepository productRepository;

	
	@GetMapping 
	public ResponseEntity<List<Product>> findAll() {	
		List <Product> list = productRepository.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) { 
		Product prod = productRepository.findById(id);
		return ResponseEntity.ok().body(prod);
	}
	

}