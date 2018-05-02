/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:34
 */

package ch.hearc.ig.odi.minishop.services;


import ch.hearc.ig.odi.minishop.business.Cart;
import ch.hearc.ig.odi.minishop.business.CartItem;
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
  private Map<Long, Cart> carts;
  private long idCounter = 3000;
  private long idCounterOrder = 101;
  private long idCounterOrderLine;
  private long idCounterCustomer = 101;
  private long idCounterProduct = 101;
  Date ajd = new Date();

  /**
   * Méthode d'initialisation permettant de générer des listes avec des données
   */
  @PostConstruct
  public void init() {
    customers = new HashMap<>();
    products = new HashMap<>();
    orders = new HashMap<>();
    carts = new HashMap<>();
    generateMockData();
  }

  /**
   * Méthode permettant de charger les listes avec des données
   */
  private void generateMockData() {
    Customer c1 = new Customer(idCounterCustomer++, "Normand", "Paratte", "nopa", "nopa@mail.com",
        "078 888 88 88");
    Customer c2 = new Customer(idCounterCustomer++, "Francis", "Heche", "frhe", "frhe@mail.com",
        "079 999 99 99");
    Customer c3 = new Customer(idCounterCustomer++, "Laure", "Dinateur", "ladi", "ladi@mail.com",
        "077 777 77 77");

    customers.put(c1.getCustomerid(), c1);
    customers.put(c2.getCustomerid(), c2);
    customers.put(c3.getCustomerid(), c3);

    Product p1 = new Product(idCounterProduct++, 10.20, "Air de Neuchâtel en bouteille",
        "Air du bord de lac neuchâtelois", "air", "active");
    Product p2 = new Product(idCounterProduct++, 3490, "Air du Luxembourg",
        "Air du Luxembourg en fiole diamentée ornée de rubis", "air", "active");
    Product p3 = new Product(idCounterProduct++, 5.10, "Eau de Neuchâtel en bouteille",
        "Eau du lac de Neuchâtel", "eau", "active");
    Product p4 = new Product(idCounterProduct++, 105.70, "Eau du Japon en bouteille",
        "Eau du Japon", "eau", "active");

    products.put(p1.getProductid(), p1);
    products.put(p2.getProductid(), p2);
    products.put(p3.getProductid(), p3);
    products.put(p4.getProductid(), p4);

    idCounterOrderLine = 1;
    OrderLine ol1 = new OrderLine(idCounterOrderLine++, p1, 2);
    OrderLine ol2 = new OrderLine(idCounterOrderLine++, p3, 12);

    idCounterOrderLine = 1;
    OrderLine ol3 = new OrderLine(idCounterOrderLine++, p2, 1);
    OrderLine ol4 = new OrderLine(idCounterOrderLine++, p4, 6);

    idCounterOrderLine = 1;
    OrderLine ol5 = new OrderLine(idCounterOrderLine++, p1, 9);
    OrderLine ol6 = new OrderLine(idCounterOrderLine++, p3, 3);
    OrderLine ol7 = new OrderLine(idCounterOrderLine++, p3, 6);
    OrderLine ol8 = new OrderLine(idCounterOrderLine++, p1, 11);

    List<OrderLine> orderLines1 = new ArrayList<>();

    orderLines1.add(ol1);
    orderLines1.add(ol2);

    Order o1 = new Order(idCounterOrder++, ajd, "paid", orderLines1);

    List<OrderLine> orderLines2 = new ArrayList<>();
    orderLines2.add(ol3);
    orderLines2.add(ol4);

    Order o2 = new Order(idCounterOrder++, ajd, "open", orderLines2);

    List<OrderLine> orderLines3 = new ArrayList<>();
    orderLines3.add(ol5);
    orderLines3.add(ol6);
    orderLines3.add(ol7);
    orderLines3.add(ol8);

    Order o3 = new Order(idCounterOrder++, ajd, "open", orderLines3);

    orders.put(o1.getOrderid(), o1);
    orders.put(o2.getOrderid(), o2);
    orders.put(o3.getOrderid(), o3);

    CartItem ci1 = new CartItem(101, p1, 2);
    CartItem ci2 = new CartItem(101, p3, 1);
    CartItem ci3 = new CartItem(101, p1, 3);
    CartItem ci4 = new CartItem(101, p2, 1);

    List<CartItem> cis1 = new ArrayList<>();
    cis1.add(ci1);
    cis1.add(ci2);

    Cart cart1 = new Cart();
    cart1.setCartid(101);
    cart1.setCartstatus("open");
    cart1.setContent(cis1);

    List<CartItem> cis2 = new ArrayList<>();
    cis2.add(ci3);
    cis2.add(ci4);

    Cart cart2 = new Cart();
    cart2.setCartid(102);
    cart2.setCartstatus("open");
    cart2.setContent(cis2);

    carts.put(cart1.getCartid(), cart1);
    carts.put(cart2.getCartid(), cart2);
  }

  // -----------------------------------------------------------------------------------------------
  // ----- CLIENTS ---------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  /**
   * Méthode permettant de récupérer tous les clients
   *
   * @return liste de tous les clients
   */
  public ArrayList<Customer> getAllCustomers() {
    ArrayList<Customer> customers = new ArrayList<>(this.customers.values());
    return customers;
  }

  /**
   * Méthode permettant de récupérer un client donné
   *
   * @param id Numéro du client
   * @return Client
   */
  public Customer getCustomer(long id) {
    return customers.get(id);
  }

  /**
   * Méthode permettant de créer un client
   *
   * @return Client créé
   */
  public Customer createCustomer(String firstname, String lastname,
      String username,
      String email, String phone) {
    Long id = idCounter++;
    Customer customer = new Customer(idCounterCustomer++, firstname, lastname, username,
        email, phone);
    customers.put(customer.getCustomerid(), customer);
    return customer;
  }

  /**
   * Méthode permettant de modifier un client
   *
   * @param cust Client avec modifications
   * @return Client modifié
   */
  public Customer updateCustomer(Customer cust) {
    Customer customer = getCustomer(cust.getCustomerid());

    customer.setFirstname(cust.getFirstname());
    customer.setLastname(cust.getLastname());
    customer.setUsername(cust.getUsername());
    customer.setEmail(cust.getEmail());
    customer.setPhone(cust.getPhone());

    customers.put(customer.getCustomerid(), customer);

    return customer;
  }

  /**
   * Méthode permettant de supprimer un client
   *
   * @param id Numéro du client
   */
  public void deleteCustomer(long id) {
    customers.remove(id);
  }

  // -----------------------------------------------------------------------------------------------
  // ----- PRODUITS --------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  /**
   * Méthode permettant de récupérer tous les produits
   *
   * @return Liste des produits
   */
  public ArrayList<Customer> getAllProducts() {
    ArrayList<Customer> products = new ArrayList(this.products.values());
    return products;
  }

  /**
   * Méthode permettant de récupérer un produit donné
   *
   * @param id Numéro du produit
   * @return Produit
   */
  public Product getProduct(long id) {
    return products.get(id);
  }

  /**
   * Méthode permettant de créer un produit
   *
   * @param price Prix
   * @param productname Nom
   * @param description Description
   * @param category Catégorie
   * @param status Statut
   * @return Produit créé
   */
  public Product createProduct(double price, String productname, String description,
      String category, String status) {
    Product product = new Product(idCounterProduct++, price, productname, description, category,
        status);
    products.put(product.getProductid(), product);
    return product;
  }

  /**
   * Méthode permettant de modifier un produit
   *
   * @param pr Produit avec modifications
   * @return Produit modifié
   */
  public Product updateProduct(Product pr) {
    Product product = getProduct(pr.getProductid());

    product.setPrice(pr.getPrice());
    product.setProductname(pr.getProductname());
    product.setDescription(pr.getDescription());
    product.setCategory(pr.getCategory());
    product.setStatus(pr.getStatus());

    products.put(product.getProductid(), product);

    return product;
  }

  /**
   * Méthode permettant de supprimer un produit
   *
   * @param id Numéro d'identification
   */
  public void deleteProduct(Long id) {
    products.remove(id);
  }

  // -----------------------------------------------------------------------------------------------
  // ----- COMMANDES -------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  /**
   * Méthode permettant de récupérer toutes les commandes
   *
   * @return Liste des commandes
   */
  public ArrayList<Order> getAllOrders() {
    ArrayList<Order> orders = new ArrayList(this.orders.values());
    return orders;
  }

  /**
   * Méthode permettant de récupérer une commande
   *
   * @param id Numéro d'identification
   * @return Commande
   */
  public Order getOrder(long id) {
    return orders.get(id);
  }

  /**
   * Méthode permettant de mettre à jour une commande
   * @param id Numéro de commande
   * @param status Statut de la commande
   * @return Commande modifiée
   */
  public Order updateOrder(long id, String status) {
    Order o = orders.get(id);
    o.setOrderstatus(status);

    orders.put(o.getOrderid(), o);

    return o;
  }

  /**
   * Méthode permettant d'ajouter de transformer un panier en commande
   *
   * @param cartId Numéro identifiant
   * @return Commande créée
   */
  public Order submitOrder(long cartId) {
    Cart c = carts.get(cartId);
    List<OrderLine> orderLines = new ArrayList<>();
    idCounterOrderLine = 1;

    for (CartItem ci : c.getContent()) {
      OrderLine ol = new OrderLine(idCounterOrderLine++, ci.getProduct(), ci.getQuantity());
      orderLines.add(ol);
    }

    Order o = new Order(idCounterOrder++, ajd, "open", orderLines);
    orders.put(o.getOrderid(), o);

    return o;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- PANIER ----------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  /**
   * Méthode permettant de récupérer un panier
   *
   * @param cartId Numéro identifiant
   * @return Panier
   */
  public Cart getCart(long cartId) {
    return carts.get(cartId);
  }

  /**
   * Méthode permettant de récupérer une ligne produit d'un panier
   *
   * @param cart Panier
   * @param productId Numéro de la ligne produit
   * @return Ligne produit du panier
   */
  public CartItem getCartItem(Cart cart, long productId){
    for(int i = 0; i<cart.getContent().size();i++) {
      if (productId==cart.getContent().get(i).getProduct().getProductid()) {
        return cart.getContent().get(0);
      }
    }
    return null;
  }

  /**
   * Méthode permettant de mettre à jour un panier
   *
   * @param cartId Numéro du panier
   * @param productId Numéro du produit
   * @param quantity Quantité
   * @return Panier avec modifications
   */
  public Cart updateCart(long cartId, long productId, int quantity) {
    Cart cart = getCart(cartId);
    CartItem ci = getCartItem(cart, productId);

    cart.updateProduct(ci, quantity);

    carts.put(cart.getCartid(),cart);

    return cart;
  }

  /**
   * Méthode permettant de supprimer une ligne de produit
   *
   * @param cartId Numéro du panier
   * @param itemId Numéro de la ligne de produit
   */
  public void deleteCartItem(long cartId, long itemId) {
    carts.get(cartId).getContent().remove(itemId);
    carts.get(cartId).deleteProduct(itemId);
  }
}