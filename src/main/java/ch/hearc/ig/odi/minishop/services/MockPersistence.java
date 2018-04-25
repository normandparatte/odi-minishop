package ch.hearc.ig.odi.minishop.services;


import ch.hearc.ig.odi.minishop.business.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class MockPersistence {

  private Map<Long, Customer> customers;
  private long idCounter = 3000;

  @PostConstruct
  public void init() {
    customers = new HashMap<>();
    generateMockData();
  }

  public ArrayList<Customer> getAllCustomers() {
    ArrayList<Customer> customers = new ArrayList<>(this.customers.values());
    return customers;
  }

  public Customer getCustomer(Long id) {
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

  public Customer updateCustomer(Long id, String firstName, String lastName, String username,
      String email, String phone) {
    Customer customer = customers.get(id);
    customer.setFirstname(firstName);
    customer.setFirstname(lastName);
    customer.setFirstname(username);
    customer.setFirstname(email);
    customer.setFirstname(phone);
    return customer;
  }

  public void deleteCustomer(Long id) {
    customers.remove(id);
  }

  private void generateMockData() {
    Customer c1 = new Customer(101, "Normand", "Paratte", "nopa", "nopa@mail.com", "078 888 88 88");
    Customer c2 = new Customer(102, "Francis", "Heche", "frhe", "frhe@mail.com", "079 999 99 99");
    Customer c3 = new Customer(103, "Laure", "Dinateur", "ladi", "ladi@mail.com", "077 777 77 77");

    customers.put(c1.getCustomerid(), c1);
    customers.put(c2.getCustomerid(), c2);
    customers.put(c3.getCustomerid(), c3);
  }
}
