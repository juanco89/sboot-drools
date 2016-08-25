package com.boot.negocio.drools;

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
  
  public void calculate(Product p) {
    ksession.execute(p);
  }
}
