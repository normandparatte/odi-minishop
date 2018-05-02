/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:37
 */

package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Customer;
import ch.hearc.ig.odi.minishop.business.Product;
import ch.hearc.ig.odi.minishop.services.MockPersistence;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/product")
public class ProductResource {

  @Inject
  private MockPersistence persistenceService;

  /**
   * Méthode GET permettant de récupérer tous les produits
   *
   * @return Liste des produits
   */
  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Customer> getProduct() {
    return persistenceService.getAllProducts();
  }

  /**
   * Méthode GET permettant de récupérer un produit donné
   *
   * @param productid Numéro identifiant
   * @return Produit demandé
   */
  @GET
  @Path("/{productid}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Product getProduct(
      @PathParam("productid") Long productid
  ) {
    return persistenceService.getProduct(productid);
  }

  /**
   * Méthode POST permettant d'ajouter un produit
   *
   * @param price Prix
   * @param productname Nom
   * @param description Description
   * @param category Catégorie
   * @param status Statut
   * @return Produit créé
   */
  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Product createProduct(
      @FormParam("price") double price,
      @FormParam("productname") String productname,
      @FormParam("description") String description,
      @FormParam("category") String category,
      @FormParam("status") String status) {
    Product product = persistenceService
        .createProduct(price, productname, description, category, status);
    return product;
  }

  /**
   * Méthode PUT permettant de modifié un produit donné
   *
   * @param pr Produit avec modifications
   * @return Produit modifié
   */
  @PUT
  @Path("/{productid}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Product updateProduct(Product pr) {
    Product product = persistenceService
        .updateProduct(pr);
    return product;
  }

  /**
   * Méthode DELETE permettant de supprimer un produit donné
   *
   * @param productid Numéro du produit
   */
  @DELETE
  @Path("/{productid}")
  public void deleteProduct(
      @PathParam("productid") long productid
  ) {
    persistenceService.deleteProduct(productid);
  }
}
