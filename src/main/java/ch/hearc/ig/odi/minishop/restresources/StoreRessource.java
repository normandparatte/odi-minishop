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

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Cart createCart(
      @PathParam("id") long customerid,
      @FormParam("productid") long productid,
      @FormParam("quantity") int quantity
  ) {
    Cart newCart = new Cart();
    newCart.addProduct(persistenceService.getProduct(productid), quantity);
    return newCart;
  }

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
    cart.addProduct(persistenceService.getProduct(productid), quantity);
    return cart;
  }

  @GET
  @Path("/{cartId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Cart getCart(
      @PathParam("id") long id,
      @PathParam("cartId") long cartId
  ) {
    return persistenceService.getCart((int) cartId);
  }

  @GET
  @Path("/{cartId}/total")
  @Produces(MediaType.APPLICATION_JSON)
  public BigDecimal getCartTotal(
      @PathParam("id") long id,
      @PathParam("cartId") long cartId
  ) {
    return persistenceService.getCart(cartId).getTotal();
  }

  @PUT
  @Path("/{cartId}")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Cart updateCart(
      @PathParam("id") long customerId,
      @PathParam("cartId") long cartId,
      @FormParam("productId") long productId,
      @FormParam("quantity") int quantity
  ) {
    Cart c = persistenceService.updateCart(cartId, productId, quantity);
    return c;
  }

  @DELETE
  @Path("/{cartId}/item/{itemId}")
  public void deleteProduct(
      @PathParam("cartId") long cartId,
      @PathParam("itemId") long itemId
  ) {
    persistenceService.getCart(cartId).deleteProduct(itemId);
  }
}
