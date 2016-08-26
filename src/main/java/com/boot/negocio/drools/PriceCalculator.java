package com.boot.negocio.drools;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.boot.modelo.entidades.Product;

public class PriceCalculator {

  private final StatelessKieSession ksession; 
  
  public PriceCalculator() {
    KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
    ksession = kc.newStatelessKieSession("pricesKS");
  }
  
  public void calculate(List<Product> p) {
    ksession.execute(p);
  }
}
