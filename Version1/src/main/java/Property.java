import java.util.Objects;

/**
 * This class represent a property.
 *
 * @author Shaohua Guo
 */
public abstract class Property {

  private static final Integer MIN_SIZE = 0;
  protected String address;
  protected Integer size;

  /**
   * Constructor for creating a property with given address and size.
   *
   * @param address The address of the property.
   * @param size    The size of the property in square feet.
   */
  public Property(String address, Integer size) throws IllegalArgumentException {
    if (size < MIN_SIZE) {
      throw new IllegalArgumentException("Size must be at least " + MIN_SIZE + " square feet.");
    }
    this.address = address;
    this.size = size;
  }

  /**
   * Getter for the address.
   *
   * @return The address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Getter for the size.
   *
   * @return The size
   */
  public Integer getSize() {
    return size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Property property = (Property) o;
    return Objects.equals(address, property.address) && Objects.equals(size,
        property.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, size);
  }

  @Override
  public String toString() {
    return "Property{" +
        "address='" + address + '\'' +
        ", size=" + size +
        '}';
  }
}
