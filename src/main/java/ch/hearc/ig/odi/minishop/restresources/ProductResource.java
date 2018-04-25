package ch.hearc.ig.odi.minishop.restresources;

import ch.hearc.ig.odi.minishop.business.Customer;
import ch.hearc.ig.odi.minishop.business.Product;
import ch.hearc.ig.odi.minishop.services.MockPersistence;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/product")
public class ProductResource {

  @Inject
  private MockPersistence persistenceService;

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Customer> getProduct() {
    return persistenceService.getAllProducts();
  }

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Product createProduct(
      @FormParam("productid") long productid,
      @FormParam("price") double price,
      @FormParam("productname") String productname,
      @FormParam("description") String description,
      @FormParam("category") String category,
      @FormParam("status") String status) {
    Product product = persistenceService
        .createProduct(productid, price, productname, description, category, status);
    return product;
  }

}
