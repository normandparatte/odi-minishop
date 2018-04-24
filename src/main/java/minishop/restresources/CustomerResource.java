package minishop.restresources;

import minishop.services.MockPersistence;
import minishop.business.Customer;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/customer")
public class CustomerResource {

  @Inject
  private MockPersistence persistenceService;

  @GET
  @Path("/")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public List<Customer> getPeople() {
    return persistenceService.getAllPersons();
  }


}
