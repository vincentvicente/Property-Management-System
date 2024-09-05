import java.util.Objects;

/**
 * This class represents a commercial property.
 *
 * @author Shaohua Guo
 */
public class Commercial extends Property {

  private static final Integer MIN_OFFICES = 0;
  private Integer numOffices;
  private Boolean retailable;

  /**
   * Constructs a new commercial property.
   *
   * @param address    the address
   * @param size       the size of the property
   * @param numOffices the number of offices
   * @param retailable true if the property is suitable for retail, false otherwise
   * @throws IllegalArgumentException if the number of offices is negative
   */
  public Commercial(String address, Integer size, Integer numOffices, Boolean retailable)
      throws IllegalArgumentException {
    super(address, size);
    if (numOffices < MIN_OFFICES) {
      throw new IllegalArgumentException("Number of offices must be non-negative.");
    }
    this.numOffices = numOffices;
    this.retailable = retailable;
  }

  /**
   * Getter for the number of offices.
   *
   * @return the number of offices
   */
  public Integer getNumOffices() {
    return numOffices;
  }

  /**
   * Getter for whether the property is suitable for retail.
   *
   * @return true if the property is suitable for retail, false otherwise
   */
  public Boolean getRetailable() {
    return retailable;
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
    Commercial that = (Commercial) o;
    return Objects.equals(numOffices, that.numOffices) && Objects.equals(
        retailable, that.retailable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOffices, retailable);
  }

  @Override
  public String toString() {
    return "Commercial{" +
        "numOffices=" + numOffices +
        ", retailable=" + retailable +
        '}';
  }
}
