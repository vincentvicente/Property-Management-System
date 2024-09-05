import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ListingTest {
  Rental rental, rental2;

  Sale sale;
  Residential residential, residential2;


  @BeforeEach
  public void setup() {
    rental = new Rental(2000.0, true, 12);
    rental2 = new Rental(21000.0, true, 12);
    sale = new Sale(300000.0, false);
    residential = new Residential("456 Elm St", 1500, 3, 2.5);
    residential = new Residential("test 2 Elm St", 300, 13, 2.5);
  }

  @Test
  public void testConstructorWithStringPropertyAndIntegerContract() {
    Listing<Residential, Rental> listing = new Listing<>(residential, rental);
    assertEquals(residential, listing.getProperty());
    assertEquals(rental, listing.getContract());
    listing.setProperty(residential2);
    assertEquals(residential2, listing.getProperty());
    listing.setContract(rental2);
    assertEquals(rental2, listing.getContract());
  }


}