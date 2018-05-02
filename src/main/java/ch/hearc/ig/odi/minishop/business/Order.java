/*
 *  Etablissement : HEG-ARC
 *  Cours : ODI SP18
 *  Projet : Minishop
 *  Auteurs : Normand Paratte & Francis Hêche
 *  Date : 02.05.18 15:37
 */

package ch.hearc.ig.odi.minishop.business;

import java.util.Date;
import java.util.List;

public class Order {

  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private long orderid;
  private Date orderdate;
  private String orderstatus;
  private List<OrderLine> content;

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  /**
   * Constructeur complet d'une commande
   *
   * @param orderid Numéro de la commande
   * @param orderdate Date de la commande
   * @param orderstatus Status de la commande
   * @param content Lignes de la commandes
   */
  public Order(long orderid, Date orderdate, String orderstatus,
      List<OrderLine> content) {
    this.orderid = orderid;
    this.orderdate = orderdate;
    this.orderstatus = orderstatus;
    this.content = content;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public long getOrderid() {
    return orderid;
  }

  public void setOrderid(long orderid) {
    this.orderid = orderid;
  }

  public Date getOrderdate() {
    return orderdate;
  }

  public void setOrderdate(Date orderdate) {
    this.orderdate = orderdate;
  }

  public String getOrderstatus() {
    return orderstatus;
  }

  public void setOrderstatus(String orderstatus) {
    this.orderstatus = orderstatus;
  }

  public List<OrderLine> getContent() {
    return content;
  }

  public void setContent(List<OrderLine> content) {
    this.content = content;
  }
}
