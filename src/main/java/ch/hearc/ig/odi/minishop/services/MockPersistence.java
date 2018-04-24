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
  }

  public ArrayList<Customer> getAllCustomers() {
    ArrayList<Customer> customers = new ArrayList<>(this.customers.values());
    return customers;
  }

}
