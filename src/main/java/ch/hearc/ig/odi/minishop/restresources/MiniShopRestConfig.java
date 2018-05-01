package ch.hearc.ig.odi.minishop.restresources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//Defines the base URI for all resource URIs.
@ApplicationPath("/api")
//The java class declares root resource and provider classes
public class MiniShopRestConfig extends Application {

  //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
  @Override
  public Set<Class<?>> getClasses() {
    HashSet resources = new HashSet<Class<?>>();
    resources.add(CustomerResource.class);
    resources.add(ProductResource.class);
    resources.add(OrderRessource.class);
    return resources;
  }

}

