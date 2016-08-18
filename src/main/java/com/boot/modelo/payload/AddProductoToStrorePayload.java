package com.boot.modelo.payload;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.boot.modelo.entidades.Product;
import com.boot.modelo.entidades.Store;

@XmlRootElement
public class AddProductoToStrorePayload implements Serializable {

  private static final long serialVersionUID = -3463498274940073821L;
  
  private final Store store;
  private final Product product;
  
  public AddProductoToStrorePayload(Store store, Product product) {
    this.store = store;
    this.product = product;
  }

  public Store getStore() {
    return store;
  }

  public Product getProduct() {
    return product;
  }
}
