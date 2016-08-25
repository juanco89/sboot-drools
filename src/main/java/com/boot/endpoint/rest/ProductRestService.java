package com.boot.endpoint.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.modelo.entidades.Product;
import com.boot.negocio.drools.PriceCalculator;
import com.boot.persistencia.jpa.ProductRepository;

@RestController
@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductRestService {
  
  @Autowired
  private ProductRepository repository;
  
  
  @RequestMapping("/listAll")
  public List<Product> listAllProducts() {
    return StreamSupport.stream(repository.findAll().spliterator(), true)
                        .collect(Collectors.toList());
  }
  
  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public Product createNewProduct(@RequestBody Product product) {
    return repository.save(product);
  }
  
  @RequestMapping(path = "/price/{productName}", method = RequestMethod.GET)
  public Product queryPriceProduct(@PathVariable("productName") String productName) {
    Product p = new Product(productName);
    PriceCalculator calculator = new PriceCalculator();
    calculator.calculate(p);
    return p;
  }
}
