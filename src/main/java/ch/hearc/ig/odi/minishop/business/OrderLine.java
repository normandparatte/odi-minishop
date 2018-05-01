package ch.hearc.ig.odi.minishop.business;

public class OrderLine {

  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private Long orderlineposition;
  private Product product;
  private Long quantity;

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public OrderLine(Long orderlineposition, Product product, Long quantity) {
    this.orderlineposition = orderlineposition;
    this.product = product;
    this.quantity = quantity;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public Long getOrderlineposition() {
    return orderlineposition;
  }

  public void setOrderlineposition(Long orderlineposition) {
    this.orderlineposition = orderlineposition;
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

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }
}
