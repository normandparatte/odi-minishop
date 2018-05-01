package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Customer;
import ch.hearc.ig.odi.minishop.business.Order;
import ch.hearc.ig.odi.minishop.services.MockPersistence;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
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
  public Order getOrder(@PathParam("orderid") Long orderid) {
    return persistenceService.getOrder(orderid);
  }
}
