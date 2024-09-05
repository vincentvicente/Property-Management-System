import java.util.Objects;

/**
 * Class representing a rental contract.
 */
public class Rental extends Contract {

  protected static final int MIN_TERM = 1;

  private int term;

  /**
   * Constructs a Rental contract with the specified asking price, negotiable status, and term.
   *
   * @param askingPrice the asking price of the rental contract, must be non-negative.
   * @param negotiable  whether the price is negotiable.
   * @param term        the term of the rental contract in months, must be greater than 0.
   */
  public Rental(double askingPrice, boolean negotiable, int term) {
    super(askingPrice, negotiable);
    if (term < MIN_TERM) {
      throw new IllegalArgumentException("Term must be greater than 0.");
    }
    this.term = term;
  }

  /**
   * Gets the term of the rental contract.
   *
   * @return the term in months.
   */
  public int getTerm() {
    return term;
  }

  /**
   * Sets the term of the rental contract.
   *
   * @param term the new term, must be greater than 0.
   */
  public void setTerm(int term) {
    if (term < MIN_TERM) {
      throw new IllegalArgumentException("Term must be greater than 0.");
    }
    this.term = term;
  }

  @Override
  public String toString() {
    return "Rental{" +
        "askingPrice=" + getAskingPrice() +
        ", negotiable=" + isNegotiable() +
        ", term=" + term +
        '}';
  }

  @Override
  public double calculateCommission(double commissionRate) {
    return commissionRate * getAskingPrice() * term;
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
    Rental rental = (Rental) o;
    return term == rental.term;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), term);
  }
}
