/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:37
 */

package ch.hearc.ig.odi.minishop.business;

public class OrderLine {

  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private long orderlineposition;
  private Product product;
  private long quantity;

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  /**
   * Constructeur complet d'une ligne de commande
   *
   * @param orderlineposition Position de la ligne de la commande
   * @param product Produit de la ligne
   * @param quantity Quantité du produit pour la commande
   */
  public OrderLine(long orderlineposition, Product product, long quantity) {
    this.orderlineposition = orderlineposition;
    this.product = product;
    this.quantity = quantity;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public long getOrderlineposition() {
    return orderlineposition;
  }

  public void setOrderlineposition(long orderlineposition) {
    this.orderlineposition = orderlineposition;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }
}
