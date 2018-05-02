/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:37
 */

package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Cart;
import ch.hearc.ig.odi.minishop.services.MockPersistence;
import java.math.BigDecimal;
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
@Path("/customer/{id}/cart")
public class StoreRessource {

  @Inject
  private MockPersistence persistenceService;

  /**
   * Méthode POST permettant de créer un panier et d'y ajouter un article
   *
   * @param customerid Numéro du client
   * @param productid Numéro du produit
   * @return Panier créé
   */
  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Cart createCart(
      @PathParam("id") long customerid,
      @FormParam("productid") long productid,
      @FormParam("quantity") int quantity
  ) {
    Cart newCart = new Cart();
    newCart.addProduct(1, persistenceService.getProduct(productid), quantity);
    return newCart;
  }

  /**
   * Méthode POST permettant de créer un panier et d'y ajouter un article
   *
   * @param customerid Numéro du client
   * @param cartid Numéro du panier
   * @param productid Numéro du produit
   * @param quantity Quantité
   * @return Panier avec article ajouté
   */
  @POST
  @Path("/{cartid}")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Cart addToCart(
      @PathParam("id") long customerid,
      @PathParam("cartid") long cartid,
      @FormParam("productid") long productid,
      @FormParam("quantity") int quantity
  ) {
    Cart cart = persistenceService.getCart(cartid);
    persistenceService.addCartItem(cart, productid, quantity);

    return cart;
  }

  /**
   * Méthode GET permettant de récupérer un panier
   *
   * @param id Numéro du client
   * @param cartId Numéro du panier
   * @return Panier recherché
   */
  @GET
  @Path("/{cartId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Cart getCart(
      @PathParam("id") long id,
      @PathParam("cartId") long cartId
  ) {
    return persistenceService.getCart(cartId);
  }

  /**
   * Méthode GET permettant de récupérer le total d'un panier
   *
   * @param id Numéro du panier
   * @return Total du panier
   */
  @GET
  @Path("/{cartId}/total")
  @Produces(MediaType.APPLICATION_JSON)
  public BigDecimal getCartTotal(
      @PathParam("id") long id,
      @PathParam("cartId") long cartId
  ) {
    return persistenceService.getCart(cartId).getTotal();
  }

  /**
   * Méthode PUT permettant de modifier un panier
   *
   * @param customerId Numéro du client
   * @param cartId Numéro du panier
   * @param productId Numéro du produit
   * @param quantity Quantité
   * @return Panier modifié
   */
  @PUT
  @Path("/{cartId}")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Cart updateCart(
      @PathParam("id") long customerId,
      @PathParam("cartId") long cartId,
      @FormParam("productid") long productId,
      @FormParam("quantity") int quantity
  ) {
    Cart c = persistenceService.updateCart(cartId, productId, quantity);
    return c;
  }

  /**
   * Méthode DELETE permettant de supprimer un panier
   *
   * @param cartId Numéro du panier
   * @param itemId Numéro de la ligne de produit
   */
  @DELETE
  @Path("/{cartId}/item/{itemId}")
  public void deleteProduct(
      @PathParam("cartId") long cartId,
      @PathParam("itemId") long itemId
  ) {
    persistenceService.deleteCartItem(cartId, itemId);
  }
}
