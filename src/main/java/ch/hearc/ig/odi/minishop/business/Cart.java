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
  public void addProduct(Product product, int quantity) {
    content.add(new CartItem(product, quantity));
  }

  public void deleteProduct(long itemIndex) {
    content.remove(itemIndex);
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
