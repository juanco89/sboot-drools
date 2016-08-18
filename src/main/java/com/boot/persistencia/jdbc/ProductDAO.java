package com.boot.persistencia.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.boot.modelo.entidades.Product;

public class ProductDAO /* extends JdbcDaoSupport */ {
  
  private JdbcTemplate jdbcTemplate;
  
  public ProductDAO(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }
  
  public List<Product> listAll() {
    String sql = "SELECT id, name FROM Product";
    return jdbcTemplate.query(sql, new ProductRowMapper());    
  }
  
}
