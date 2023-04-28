package com.dantas.springbootdemo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// depois de digitar Serializable, pressione Ctrl + Shift + O para adicionar o import
// depois disso irá aparecer um "!" na linha abaixo. Clique nele e selecione 
// "Add default serial version ID". Isso irá adicionar a variável serialVersionUID.
@Entity
public class Category implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	// É melhor usar Long (classe) do que long (tipo primitivo) pq o Long 
	// pode ser nulo e aceita conceitos de POO (herança, polimorfismo, etc).
	// Por isso é bizu usar em suas classes o tipo upper (com a primeira letra 
	// maiúscula) ao invés do tipo primitivo.
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product> products = new ArrayList<>();
	

	public Category() {}
	
	// para criar o construtor automaticamente, clique com o botão direito aqui
	// no editor de texto da IDE e clique em Source -> Generate Constructor using Fields
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	// para criar os getters e setters: Source -> Generate getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	// Source -> Generate hashCode() and equals() -> selecionar somente o id
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}	

}
