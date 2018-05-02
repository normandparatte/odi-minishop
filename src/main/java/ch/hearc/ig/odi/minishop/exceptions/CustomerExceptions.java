package ch.hearc.ig.odi.minishop.exceptions;

public class CustomerExceptions extends Exception {

  public CustomerExceptions() {
    super();
  }

  public CustomerExceptions(String message) {
    super(message);
  }

  public CustomerExceptions(String message, Throwable cause) {
    super(message, cause);
  }
}
