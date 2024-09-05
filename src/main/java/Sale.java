import java.util.Objects;

/**
 * Class representing a sale contract.
 */
public class Sale extends Contract {

  /**
   * Constructs a Sale contract with the specified asking price and negotiable status.
   *
   * @param askingPrice the asking price of the sale contract, must be non-negative.
   * @param negotiable  whether the price is negotiable.
   */
  public Sale(double askingPrice, boolean negotiable) {
    super(askingPrice, negotiable);
  }

  @Override
  public String toString() {
    return "Sale{" +
        "askingPrice=" + getAskingPrice() +
        ", negotiable=" + isNegotiable() +
        '}';
  }

  @Override
  public double calculateCommission(double commissionRate) {
    return commissionRate * getAskingPrice();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }
}
