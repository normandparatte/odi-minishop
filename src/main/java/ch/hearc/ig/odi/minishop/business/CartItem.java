/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:37
 */

package ch.hearc.ig.odi.minishop.business;

public class CartItem {

  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private long cartitemid;
  private Product product;
  private long quantity;

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  /**
   * Constructeur complet d'un article du panier
   *
   * @param cartitemid Numéro d'identification
   * @param product Produit
   * @param quantity Quantité
   */
  public CartItem(long cartitemid, Product product, long quantity) {
    this.cartitemid = cartitemid;
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * Constructeur d'un article du panier
   *
   * @param product Produit
   * @param quantity Quantité
   */
  public CartItem(Product product, long quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public long getCartitemid() {
    return cartitemid;
  }

  public void setCartitemid(long cartitemid) {
    this.cartitemid = cartitemid;
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
