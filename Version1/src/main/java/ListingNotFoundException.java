/**
 * This custom exception is thrown when a listing is not found in the system.
 *
 * @author Yitian
 */
public class ListingNotFoundException extends Throwable {

  /**
   * Constructs a new ListingNotFoundException with the specified detail message.
   *
   * @param s the detail message.
   */
  public ListingNotFoundException(String s) {
    super(s);
  }
}
