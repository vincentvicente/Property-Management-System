import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RentalTest {

  @Test
  public void testCreateValidRental() {
    Rental rental = new Rental(2000.0, true, 12);
    assertEquals(2000.0, rental.getAskingPrice());
    assertTrue(rental.isNegotiable());
    assertEquals(12, rental.getTerm());
  }

  @Test
  public void testCreateInvalidRental() {
    assertThrows(IllegalArgumentException.class, () -> new Rental(2000.0, true, 0));
  }

  @Test
  public void testSetAskingPrice() {
    Rental rental = new Rental(2000.0, true, 12);
    rental.setAskingPrice(2500.0);
    assertEquals(2500.0, rental.getAskingPrice());
    assertThrows(IllegalArgumentException.class, () -> rental.setAskingPrice(-500.0));
  }

  @Test
  public void testSetNegotiable() {
    Rental rental = new Rental(2000.0, true, 12);
    rental.setNegotiable(false);
    assertFalse(rental.isNegotiable());
  }

  @Test
  public void testSetTerm() {
    Rental rental = new Rental(2000.0, true, 12);
    rental.setTerm(24);
    assertEquals(24, rental.getTerm());
    assertThrows(IllegalArgumentException.class, () -> rental.setTerm(0));
  }

  @Test
  public void testToString() {
    Rental rental = new Rental(2000.0, true, 12);
    assertEquals("Rental{askingPrice=2000.0, negotiable=true, term=12}", rental.toString());
  }

  @Test
  public void testEquals() {
    Rental rental1 = new Rental(2000.0, true, 12);
    Rental rental2 = new Rental(2000.0, true, 12);
    Rental rental3 = new Rental(2500.0, false, 6);

    assertEquals(rental1, rental2);
    assertNotEquals(rental1, rental3);
    assertNotEquals(rental2, rental3);
  }

  @Test
  public void testHashCode() {
    Rental rental1 = new Rental(2000.0, true, 12);
    Rental rental2 = new Rental(2000.0, true, 12);
    Rental rental3 = new Rental(2500.0, false, 6);

    assertEquals(rental1.hashCode(), rental2.hashCode());
    assertNotEquals(rental1.hashCode(), rental3.hashCode());
  }

  @Test
  public void testCalculateCommission() {
    Rental rental = new Rental(2000.0, true, 12);
    double commissionRate = 0.03;
    double expectedCommission = 0.03 * 2000.0 * 12;
    assertEquals(expectedCommission, rental.calculateCommission(commissionRate), 0.0001);
  }
}
