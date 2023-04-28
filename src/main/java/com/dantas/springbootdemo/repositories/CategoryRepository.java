package com.dantas.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dantas.springbootdemo.entities.Category;

@Repository 
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}