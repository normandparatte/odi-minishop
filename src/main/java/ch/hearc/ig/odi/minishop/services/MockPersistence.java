package ch.hearc.ig.odi.minishop.services;


import ch.hearc.ig.odi.minishop.business.Customer;
import ch.hearc.ig.odi.minishop.business.Order;
import ch.hearc.ig.odi.minishop.business.OrderLine;
import ch.hearc.ig.odi.minishop.business.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class MockPersistence {

  // -----------------------------------------------------------------------------------------------
  // ----- INITIALISATION --------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private Map<Long, Customer> customers;
  private Map<Long, Product> products;
  private Map<Long, Order> orders;
  private long idCounter = 3000;

  @PostConstruct
  public void init() {
    customers = new HashMap<>();
    products = new HashMap<>();
    orders = new HashMap<>();
    generateMockData();
  }

  private void generateMockData() {
    Customer c1 = new Customer(101, "Normand", "Paratte", "nopa", "nopa@mail.com", "078 888 88 88");
    Customer c2 = new Customer(102, "Francis", "Heche", "frhe", "frhe@mail.com", "079 999 99 99");
    Customer c3 = new Customer(103, "Laure", "Dinateur", "ladi", "ladi@mail.com", "077 777 77 77");

    customers.put(c1.getCustomerid(), c1);
    customers.put(c2.getCustomerid(), c2);
    customers.put(c3.getCustomerid(), c3);

    Product p1 = new Product(101, 10.20, "Air de Neuchâtel en bouteille",
        "Air du bord de lac neuchâtelois", "air", "active");
    Product p2 = new Product(102, 3490, "Air du Luxembourg",
        "Air du Luxembourg en fiole diamentée ornée de rubis", "air", "active");
    Product p3 = new Product(103, 5.10, "Eau de Neuchâtel en bouteille",
        "Eau du lac de Neuchâtel", "eau", "active");
    Product p4 = new Product(104, 105.70, "Eau du Japon en bouteille",
        "Eau du Japon", "eau", "active");

    products.put(p1.getProductid(), p1);
    products.put(p2.getProductid(), p2);
    products.put(p3.getProductid(), p3);
    products.put(p4.getProductid(), p4);

    OrderLine ol1 = new OrderLine(101, p1,2);
    OrderLine ol2 = new OrderLine(102, p3, 12);
    OrderLine ol3 = new OrderLine(103, p2, 1);
    OrderLine ol4 = new OrderLine(104, p4, 6);
    OrderLine ol5 = new OrderLine(105, p1, 9);
    OrderLine ol6 = new OrderLine(106, p3, 3);
    OrderLine ol7 = new OrderLine(107, p3, 6);
    OrderLine ol8 = new OrderLine(108, p1, 11);

    List<OrderLine> orderLines1 = new ArrayList<>();

    orderLines1.add(ol1);
    orderLines1.add(ol2);

    Order o1 = new Order(101, new Date(2017/24/02), "paid", orderLines1);

    List<OrderLine> orderLines2 = new ArrayList<>();
    orderLines2.add(ol3);
    orderLines2.add(ol4);

    Order o2 = new Order(102, new Date(2018/01/21), "open", orderLines2);

    List<OrderLine> orderLines3 = new ArrayList<>();
    orderLines3.add(ol5);
    orderLines3.add(ol6);
    orderLines3.add(ol7);
    orderLines3.add(ol8);

    Order o3 = new Order(103, new Date(2018/01/27), "open", orderLines3);

    orders.put(o1.getOrderid(),o1);
    orders.put(o2.getOrderid(),o2);
    orders.put(o3.getOrderid(),o3);
  }

  // -----------------------------------------------------------------------------------------------
  // ----- CLIENTS ---------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public ArrayList<Customer> getAllCustomers() {
    ArrayList<Customer> customers = new ArrayList<>(this.customers.values());
    return customers;
  }

  public Customer getCustomer(long id) {
    return customers.get(id);
  }

  public Customer createCustomer(long customerid, String firstname, String lastname,
      String username,
      String email, String phone) {
    Long id = idCounter++;
    Customer customer = new Customer(customerid, firstname, lastname, username,
        email, phone);
    customers.put(customer.getCustomerid(), customer);
    return customer;
  }

  public Customer updateCustomer(long id, String firstName, String lastName, String username,
      String email, String phone) {
    Customer customer = customers.get(id);
    customer.setFirstname(firstName);
    customer.setFirstname(lastName);
    customer.setFirstname(username);
    customer.setFirstname(email);
    customer.setFirstname(phone);
    return customer;
  }

  public void deleteCustomer(long id) {
    customers.remove(id);
  }

  // -----------------------------------------------------------------------------------------------
  // ----- PRODUITS --------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public ArrayList<Customer> getAllProducts() {
    ArrayList<Customer> products = new ArrayList(this.products.values());
    return products;
  }

  public Product getProduct(long id) {
    return products.get(id);
  }

  public Product createProduct(long productid, double price, String productname, String description,
      String category, String status) {
    Long id = idCounter++;
    Product product = new Product(productid, price, productname, description, category, status);
    products.put(product.getProductid(), product);
    return product;
  }

  public Product updateProduct(long productid, double price, String productname, String description,
      String category, String status) {
    Product product = products.get(productid);
    product.setProductid(productid);
    product.setPrice(price);
    product.setProductname(productname);
    product.setDescription(description);
    product.setCategory(category);
    product.setStatus(status);
    return product;
  }

  public void deleteProduct(Long id) {
    products.remove(id);
  }

  // -----------------------------------------------------------------------------------------------
  // ----- COMMANDES -------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public ArrayList<Order> getAllOrders() {
    ArrayList<Order> orders = new ArrayList(this.orders.values());
    return orders;
  }

  public Order getOrder(long id) {
    return orders.get(id);
  }
}
