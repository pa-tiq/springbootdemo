package com.dantas.springbootdemo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dantas.springbootdemo.entities.Category;

@Component // Define que essa classe vai participar do mecanismo de injeção de dependências.
// anotação necessária para que a instância @AutoWired presente no CategoryResource funcione
public class CategoryRepository {
	
	private Map<Long,Category> map = new HashMap<>();

	public void save(Category obj) {
		map.put(obj.getId(), obj);
	}

	public Category findById(Long id) {
		return map.get(id);
	}
	
	public List<Category> findAll() {
		return new ArrayList<Category>(map.values());
	}
}