/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:37
 */

package ch.hearc.ig.odi.minishop.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {

  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private long cartid;
  private String cartstatus;
  private List<CartItem> content = new ArrayList<>();

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public Cart() {
  }

  // -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS METIERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  /**
   * Permet d'ajouter un produit à un panier
   *
   * @param product Produit à ajouter
   * @param quantity Quantité du produit
   */
  public void addProduct(Product product, int quantity) {
    content.add(new CartItem(product, quantity));
  }

  /**
   * Permet de supprimer un produit d'un panier
   *
   * @param itemIndex Numéro du produit à supprimer
   */
  public void deleteProduct(long itemIndex) {
    content.remove(itemIndex);
  }

  /**
   * Permet de modifier le produit d'un panier
   *
   * @param cartid Numéro d'identification
   * @param quantity Quantité
   */
  public void updateProduct(CartItem cartid, int quantity) {
    content.get(content.indexOf(cartid)).setQuantity(quantity);
  }

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public long getCartid() {
    return cartid;
  }

  public void setCartid(long cartid) {
    this.cartid = cartid;
  }

  public String getCartstatus() {
    return cartstatus;
  }

  public void setCartstatus(String cartstatus) {
    this.cartstatus = cartstatus;
  }

  public List<CartItem> getContent() {
    return content;
  }

  public void setContent(List<CartItem> content) {
    this.content = content;
  }

  public BigDecimal getTotal() {
    BigDecimal total = new BigDecimal(0);
    for (int i = 0; i < content.size(); ++i) {
      total = total.add(
          new BigDecimal(content.get(i).getQuantity()).multiply(
              new BigDecimal(content.get(i).getProduct().getPrice())
          )
      );
    }
    return total;
  }
}
