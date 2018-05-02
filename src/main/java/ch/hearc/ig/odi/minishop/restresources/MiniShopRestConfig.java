/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:36
 */

package ch.hearc.ig.odi.minishop.restresources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class MiniShopRestConfig extends Application {

  /**
   * Méthode permettant de signaler les classes qui doivent être publiées par JAX-RS
   *
   * @return List des classes devant être publiées
   */
  @Override
  public Set<Class<?>> getClasses() {
    HashSet resources = new HashSet<Class<?>>();
    resources.add(CustomerResource.class);
    resources.add(ProductResource.class);
    resources.add(OrderRessource.class);
    resources.add(StoreRessource.class);
    return resources;
  }

}

