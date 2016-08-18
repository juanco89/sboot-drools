package com.boot.persistencia.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boot.modelo.entidades.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
  
  List<Product> findByName(String name);
  
}
