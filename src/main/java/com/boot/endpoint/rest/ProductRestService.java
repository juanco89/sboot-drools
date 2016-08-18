package com.boot.endpoint.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.modelo.entidades.Product;
import com.boot.persistencia.jpa.ProductRepository;

@Controller
@EnableAutoConfiguration
@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductRestService {
  
  @Autowired
  private ProductRepository repository;
  
  @ResponseBody
  @RequestMapping("/listAll")
  public List<Product> listAllProducts() {
    return StreamSupport.stream(repository.findAll().spliterator(), true)
                        .collect(Collectors.toList());
  }
  
  @ResponseBody
  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public Product createNewProduct(@RequestBody Product product) {
    return repository.save(product);
  }
}
