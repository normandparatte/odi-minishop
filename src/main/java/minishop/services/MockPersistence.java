package minishop.services;


import minishop.business.Customer;

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

  public ArrayList<Customer> getAllPersons() {
    ArrayList<Customer> customer = new ArrayList<>(customers.values());
    return customer;
  }

  private void generateMockData() {
     //add data
  }
}
