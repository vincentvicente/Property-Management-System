import java.util.Objects;

/**
 * Abstract class representing a contract.
 *
 * @author Qiyuan Zhu
 */
public abstract class Contract {

  protected static final double MIN_PRICE = 0.0;

  private double askingPrice;
  private boolean negotiable;

  /**
   * Constructs a Contract with the specified asking price and negotiable status.
   *
   * @param askingPrice the asking price of the contract, must be non-negative.
   * @param negotiable  whether the price is negotiable.
   */
  public Contract(double askingPrice, boolean negotiable) {
    if (askingPrice < MIN_PRICE) {
      throw new IllegalArgumentException("Asking price cannot be negative.");
    }
    this.askingPrice = askingPrice;
    this.negotiable = negotiable;
  }

  /**
   * Gets the asking price of the contract.
   *
   * @return the asking price.
   */
  public double getAskingPrice() {
    return askingPrice;
  }

  /**
   * Sets the asking price of the contract.
   *
   * @param askingPrice the new asking price, must be non-negative.
   */
  public void setAskingPrice(double askingPrice) {
    if (askingPrice < MIN_PRICE) {
      throw new IllegalArgumentException("Asking price cannot be negative.");
    }
    this.askingPrice = askingPrice;
  }

  /**
   * Checks if the price is negotiable.
   *
   * @return true if the price is negotiable, false otherwise.
   */
  public boolean isNegotiable() {
    return negotiable;
  }

  /**
   * Sets whether the price is negotiable.
   *
   * @param negotiable the new negotiable status.
   */
  public void setNegotiable(boolean negotiable) {
    this.negotiable = negotiable;
  }

  /**
   * Calculates the commission based on the type of contract and the agent's commission rate.
   *
   * @param commissionRate The commission rate of the agent.
   * @return The commission earned from the contract.
   */
  public abstract double calculateCommission(double commissionRate);

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contract contract = (Contract) o;
    return Double.compare(askingPrice, contract.askingPrice) == 0
        && negotiable == contract.negotiable;
  }

  @Override
  public int hashCode() {
    return Objects.hash(askingPrice, negotiable);
  }

  @Override
  public String toString() {
    return "Contract{" +
        "askingPrice=" + askingPrice +
        ", negotiable=" + negotiable +
        '}';
  }
}
