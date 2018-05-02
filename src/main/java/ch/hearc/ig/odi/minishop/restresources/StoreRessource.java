package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Cart;
import ch.hearc.ig.odi.minishop.services.MockPersistence;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/store")
public class StoreRessource {

  @Inject
  private MockPersistence persistenceService;

  @POST
  @Path("/customer/{id}/cart")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Cart createCart(
      @PathParam("id") long customerid,
      @FormParam("productid") long productid,
      @FormParam("quantity") int quantity
  ) {
    Cart newCart = new Cart();
    newCart.ajouterProduit(persistenceService.getProduct(productid), quantity);
    return newCart;
  }

  @GET
  @Path("/customer/{id}/cart/{cartId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Cart getCart(
      @PathParam("id") long id,
      @PathParam("cartId") long cartId
  ) {
    return persistenceService.getCart((int) cartId);
  }
}