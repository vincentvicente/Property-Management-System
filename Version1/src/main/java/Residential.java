import java.util.Objects;

/**
 * This class represents a residential property.
 *
 * @author Shaohua Guo
 */
public class Residential extends Property {

  private static final Integer MIN_NUM_BED = 0;
  private static final Double MIN_NUM_BATH = 0.0;
  private Integer numBedrooms;
  private Double numBathrooms;

  /**
   * Constructor for residential properties.
   *
   * @param address      the address
   * @param size         the size of the property
   * @param numBedrooms  the number of bedrooms
   * @param numBathrooms the number of bathrooms
   * @throws IllegalArgumentException if the number of bedrooms and bathrooms is negative
   */
  public Residential(String address, Integer size, Integer numBedrooms, Double numBathrooms)
      throws IllegalArgumentException {
    super(address, size);
    if (numBedrooms < MIN_NUM_BED || numBathrooms < MIN_NUM_BATH) {
      throw new IllegalArgumentException("Number of bedrooms and bathrooms must be non-negative.");
    }
    this.numBedrooms = numBedrooms;
    this.numBathrooms = numBathrooms;
  }

  /**
   * Getter for the number of bedrooms
   *
   * @return the number of bedrooms
   */
  public Integer getNumBedrooms() {
    return numBedrooms;
  }

  /**
   * Getter for the number of bathrooms
   *
   * @return the number of bathrooms
   */
  public Double getNumBathrooms() {
    return numBathrooms;
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
    Residential that = (Residential) o;
    return Objects.equals(numBedrooms, that.numBedrooms) && Objects.equals(
        numBathrooms, that.numBathrooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numBedrooms, numBathrooms);
  }

  @Override
  public String toString() {
    return "Residential{" +
        "numBedrooms=" + numBedrooms +
        ", numBathrooms=" + numBathrooms +
        '}';
  }
}
