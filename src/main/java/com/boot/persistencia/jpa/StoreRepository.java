package com.boot.persistencia.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boot.modelo.entidades.Store;

public interface StoreRepository extends CrudRepository<Store, Long> {
  
  List<Store> findByName(String name);
  
}
