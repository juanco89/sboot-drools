package com.boot.endpoint.rest;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.modelo.entidades.Product;
import com.boot.persistencia.jdbc.ProductDAO;

@Controller
@EnableAutoConfiguration
@RequestMapping(path = "/productLegacy", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductLegacyRestService {
  
  @Autowired
  private DataSource dataSource;
  
  @ResponseBody
  @RequestMapping("/listAll")
  public List<Product> listAllProducts() {
    ProductDAO dao = new ProductDAO(dataSource);
    return dao.listAll();
  }
}
