import java.util.Objects;

/**
 * Represents a listing in a property management system.
 * A listing consists of a contract and a property.
 */
public class Listing<P extends Property, C extends Contract> {
  private P property;
  private C contract;

  /**
   * Constructs a new Listing object with the given contract and property.
   *
   * @param contract The contract associated with the listing.
   * @param property The property associated with the listing.
   */
  public Listing(P property, C contract) {
    this.contract = contract;
    this.property = property;
  }

  /**
   * Returns the contract associated with the listing.
   *
   * @return The contract associated with the listing.
   */
  public C getContract() {
    return contract;
  }

  /**
   * Sets the contract associated with the listing.
   *
   * @param contract The contract to be associated with the listing.
   */
  public void setContract(C contract) {
    this.contract = contract;
  }

  /**
   * Returns the property associated with the listing.
   *
   * @return The property associated with the listing.
   */
  public P getProperty() {
    return property;
  }

  /**
   * Sets the property associated with the listing.
   *
   * @param property The property to be associated with the listing.
   */
  public void setProperty(P property) {
    this.property = property;
  }

  /**
   * Compares this listing to another object for equality.
   * Two listings are considered equal if their contracts and properties are equal.
   *
   * @param o The object to be compared with this listing.
   * @return True if the given object is equal to this listing, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Listing listing = (Listing) o;
    return Objects.equals(property, listing.property) && Objects.equals(contract,
        listing.contract);
  }

  /**
   * Returns a hash code value for this listing.
   *
   * @return The hash code value for this listing.
   */
  @Override
  public int hashCode() {
    return Objects.hash(property, contract);
  }

  /**
   * Returns a string representation of this listing.
   *
   * @return A string representation of this listing.
   */
  @Override
  public String toString() {
    return "Listing{" +
        "contract=" + contract +
        ", property=" + property +
        '}';
  }
}
