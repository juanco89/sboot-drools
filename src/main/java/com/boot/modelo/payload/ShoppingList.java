package com.boot.modelo.payload;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ShoppingList implements Serializable {

  private static final long serialVersionUID = -8184302638351262770L;
  
  private List<ShoppingItem> list;

  public List<ShoppingItem> getList() {
    return list;
  }

  public void setList(List<ShoppingItem> list) {
    this.list = list;
  }
}
