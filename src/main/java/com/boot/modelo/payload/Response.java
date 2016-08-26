package com.boot.modelo.payload;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response<T> implements Serializable {

  private static final long serialVersionUID = 4562229621311158078L;
  
  private T value;

  public Response(T value) {
    this.value = value;
  }
  
  public Response() {
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
