/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:36
 */

package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Customer;
import ch.hearc.ig.odi.minishop.services.MockPersistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  // FIXME: cette méthode permet de tester le bon fonctionnement du marshalling JSON. Effacez-la une fois votre code en place.
  @GET
  @Path("/json")
  @Produces(MediaType.APPLICATION_JSON)
  public Map getJson() {
    Map<String, String> theMap = new HashMap<>();
    theMap.put("foo", "bar");
    return theMap;
  }

  // FIXME: cette méthode permet de tester le bon fonctionnement du marshalling JSON. Effacez-la une fois votre code en place.
  @POST
  @Path("/json")
  @Produces(MediaType.APPLICATION_JSON)
  public Map postJson(HashMap theMap) {
    return theMap;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Customer> getCustomer() {
    return persistenceService.getAllCustomers();
  }

  @GET
  @Path("/{customerid}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Customer getCustomer(@PathParam("customerid") Long customerid) {
    return persistenceService.getCustomer(customerid);
  }

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Customer createCustomer(
      @FormParam("id") long id,
      @FormParam("firstName") String firstName,
      @FormParam("lastName") String lastName,
      @FormParam("username") String username,
      @FormParam("email") String email,
      @FormParam("phone") String phone) {
    Customer customer = persistenceService
        .createCustomer(id, firstName, lastName, username, email, phone);
    return customer;
  }

  @PUT
  @Path("/{customerid}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces({MediaType.APPLICATION_JSON})
  public Customer updateCustomer(Customer cust){
    Customer customer = persistenceService
        .updateCustomer(cust);
    return customer;
  }

  @DELETE
  @Path("/{customerid}")
  public void deleteCustomer(@PathParam("customerid") Long personid) {
    persistenceService.deleteCustomer(personid);
  }
}