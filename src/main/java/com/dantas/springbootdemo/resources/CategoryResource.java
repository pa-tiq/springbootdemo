package com.dantas.springbootdemo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dantas.springbootdemo.entities.Category;
import com.dantas.springbootdemo.repositories.CategoryRepository;

@RestController // define que essa classe é um recurso REST
@RequestMapping(value = "/categories") // define o caminho pelo qual esse recurso vai responder
public class CategoryResource {
	
	@Autowired
	private CategoryRepository categoryRepository;

	
	@GetMapping // define que esse método é responsável por responder requisições GET
	public ResponseEntity<List<Category>> findAll() {
		List <Category> list = categoryRepository.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}") // responde em /categories/id
	public ResponseEntity<Category> findById(@PathVariable Long id) { //@PathVariable serve para reconhecer o id que vc coloca na URL
		Category cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}
	
}
