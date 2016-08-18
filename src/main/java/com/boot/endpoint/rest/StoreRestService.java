package com.boot.endpoint.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.modelo.entidades.Store;
import com.boot.persistencia.jpa.StoreRepository;

@RestController
@RequestMapping(path = "/store", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreRestService {
  
  @Autowired
  private StoreRepository repository;
  

  @RequestMapping("/listAll")
  public List<Store> listAllStores() {
    return StreamSupport.stream(repository.findAll().spliterator(), true)
                        .collect(Collectors.toList());
  }
  
  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public Store createNewStore(@RequestBody Store store) {
    return repository.save(store);
  }
  
}
