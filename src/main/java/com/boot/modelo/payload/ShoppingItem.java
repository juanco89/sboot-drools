package com.boot.modelo.payload;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.boot.modelo.entidades.Product;

@XmlRootElement
public class ShoppingItem implements Serializable {

  private static final long serialVersionUID = -5860582537936060347L;

  private Product product;
  
  private int quantity;

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
