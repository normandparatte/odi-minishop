/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:37
 */

package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Customer;
import ch.hearc.ig.odi.minishop.business.Order;
import ch.hearc.ig.odi.minishop.services.MockPersistence;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/order")
public class OrderRessource {

  @Inject
  private MockPersistence persistenceService;

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Order> getOrders() {
    return persistenceService.getAllOrders();
  }

  @GET
  @Path("/{orderid}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Order getOrder(@PathParam("orderid") long orderid) {
    return persistenceService.getOrder(orderid);
  }

  @PUT
  @Path("/{orderid}")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Order updateOrder(@PathParam("orderid") long orderid,
      @FormParam("newstatus") String newstatus) {
    Order o = persistenceService
        .updateOrder(orderid, newstatus);
    return o;
  }

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Order submitOrder(
      @FormParam("cartid") long cartid) {
    Order order = persistenceService
        .submitOrder(cartid);
    return order;
  }
}