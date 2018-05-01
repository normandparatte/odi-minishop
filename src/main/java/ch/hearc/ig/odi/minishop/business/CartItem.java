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
  public CartItem(long cartitemid, Product product, long quantity) {
    this.cartitemid = cartitemid;
    this.product = product;
    this.quantity = quantity;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public Long getCartitemid() {
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

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }
}
