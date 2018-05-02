/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:36
 */

package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Customer;
import ch.hearc.ig.odi.minishop.exceptions.CustomerExceptions;
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
@Path("/customer")
public class CustomerResource {

  @Inject
  private MockPersistence persistenceService;

  /**
   * Méthode GET permettant de récupérer tous les clients
   *
   * @return Liste de tous les clients
   */
  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Customer> getCustomer() {
    return persistenceService.getAllCustomers();
  }

  /**
   * Méthode GET permettant de récupérer un client donné
   *
   * @param customerid Numéro identifiant
   * @return Client demandé
   */
  @GET
  @Path("/{customerid}")
  @Produces(MediaType.APPLICATION_JSON)
  public Customer getCustomer(
      @PathParam("customerid") Long customerid
  ) throws CustomerExceptions {
    Customer customer;
    try {
      customer = persistenceService.getCustomer(customerid);
    } catch (Exception e) {
      throw new CustomerExceptions("404 - The customer does not exist");
    }
    return customer;
  }

  /**
   * Méthode POST permettant de récupérer un client donné
   *
   * @param firstName Prénom
   * @param lastName Nom de famille
   * @param username Nom d'utilisateur
   * @param email Email
   * @param phone Téléphone
   * @return Client demandé
   */
  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  public Customer createCustomer(
      @FormParam("firstName") String firstName,
      @FormParam("lastName") String lastName,
      @FormParam("username") String username,
      @FormParam("email") String email,
      @FormParam("phone") String phone) throws CustomerExceptions {
    Customer customer;

    try {
      customer = persistenceService.createCustomer(firstName, lastName, username, email, phone);
    } catch (Exception e) {
      throw new CustomerExceptions("400 - customer couldn't have been created");
    }
    return customer;
  }

  /**
   * Méthode PUT permettant de modifier un client
   *
   * @param cust Client avec modifications
   * @return Client modifié
   */
  @PUT
  @Path("/{customerid}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Customer updateCustomer(Customer cust) throws CustomerExceptions {
    Customer customer = null;
    try {
      customer = persistenceService.updateCustomer(cust);
    } catch (Exception e) {
      throw new CustomerExceptions("400 - customer couldn't have been updated");
    }
    return customer;
  }

  /**
   * Méthode DELETE permettant de supprimer un client
   *
   * @param personid Numéro identifiant
   */
  @DELETE
  @Path("/{customerid}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void deleteCustomer(
      @PathParam("customerid") Long personid) throws CustomerExceptions {
    try {
      persistenceService.deleteCustomer(personid);
    } catch (Exception e) {
      throw new CustomerExceptions("400 - Customer couldn't have been deleted");
    }
  }
}