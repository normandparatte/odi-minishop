package ch.hearc.ig.odi.minishop.business;

public class CartItem {
  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private Long cartitemid;
  private Product product;
  private Long quantity;

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  public CartItem(Long cartitemid, Product product, Long quantity) {
    this.cartitemid = cartitemid;
    this.product = product;
    this.quantity = quantity;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  public Long getCartitemid() {return cartitemid;}

  public void setCartitemid(Long cartitemid) {this.cartitemid = cartitemid;}

  public Product getProduct() {return product;}

  public void setProduct(Product product) {this.product = product;}

  public Long getQuantity() {return quantity;}

  public void setQuantity(Long quantity) {this.quantity = quantity;}
}
