/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:37
 */

package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Order;
import ch.hearc.ig.odi.minishop.exceptions.OrderExceptions;
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

  /**
   * Méthode GET permettant de récupérer toutes les commandes
   *
   * @return Liste des commandes demandées
   */
  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Order> getOrders() {
    return persistenceService.getAllOrders();
  }

  /**
   * Méthode GET permettant de récupérer une commande donnée
   *
   * @param orderid Numéro identifiant
   * @return Commande demandée
   */
  @GET
  @Path("/{orderid}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Order getOrder(
      @PathParam("orderid") long orderid
  ) throws OrderExceptions {
    Order o;

    try {
      o = persistenceService.getOrder(orderid);
    } catch (Exception e) {
      throw new OrderExceptions("404 - Not found");
    }
    return o;
  }

  /**
   * Méthode PUT permettant de modifier le statut d'une commande
   *
   * @param orderid Numéro identifiant
   * @param newstatus Nouveau statut
   * @return Commande modifiée
   */
  @PUT
  @Path("/{orderid}")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Order updateOrder(@PathParam("orderid") long orderid,
      @FormParam("newstatus") String newstatus
  ) throws OrderExceptions {
    Order o;

    try {
      o = persistenceService.updateOrder(orderid, newstatus);
    } catch (Exception e) {
      throw new OrderExceptions("400 - Status not updated");
    }

    return o;
  }

  /**
   * Méthode POST permettant d'ajouter de transformer un panier en commande
   *
   * @param cartid Numéro identifiant
   * @return Commande créée
   */
  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Order submitOrder(
      @FormParam("cartid") long cartid
  ) throws OrderExceptions {
    Order order;
    try {
      order = persistenceService.submitOrder(cartid);
    } catch (Exception e) {
      throw new OrderExceptions("400 - order was not created.");
    }
    return order;
  }
}