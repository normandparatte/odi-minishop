package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Customer;
import ch.hearc.ig.odi.minishop.services.MockPersistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
  public List<Customer> getPeople() {
    return persistenceService.getAllCustomers();
  }

  @GET
  @Path("/{personid}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Customer getPerson(@PathParam("personid") Long personid) {
    return persistenceService.getCustomer(personid);
  }
}
