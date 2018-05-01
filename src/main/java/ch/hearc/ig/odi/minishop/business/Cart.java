package ch.hearc.ig.odi.minishop.business;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private Long cartid;
  private String cartstatus;
  private List<CartItem> content = new ArrayList<>();

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  public Cart(Long cartid, String cartstatus, List<CartItem> content) {
    this.cartid = cartid;
    this.cartstatus = cartstatus;
    this.content = content;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public Long getCartid() {return cartid;}

  public void setCartid(Long cartid) {this.cartid = cartid;}

  public String getCartstatus() {return cartstatus;}

  public void setCartstatus(String cartstatus) {this.cartstatus = cartstatus;}

  public List<CartItem> getContent() {return content;}

  public void setContent(List<CartItem> content) {this.content = content;}
}
