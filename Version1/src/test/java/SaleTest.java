import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {

  @Test
  public void testCreateSale() {
    Sale sale = new Sale(300000.0, false);
    assertEquals(300000.0, sale.getAskingPrice());
    assertFalse(sale.isNegotiable());
  }

  @Test
  public void testSetAskingPrice() {
    Sale sale = new Sale(300000.0, false);
    sale.setAskingPrice(350000.0);
    assertEquals(350000.0, sale.getAskingPrice());
    assertThrows(IllegalArgumentException.class, () -> sale.setAskingPrice(-100.0));
  }

  @Test
  public void testSetNegotiable() {
    Sale sale = new Sale(300000.0, false);
    sale.setNegotiable(true);
    assertTrue(sale.isNegotiable());
  }

  @Test
  public void testToString() {
    Sale sale = new Sale(300000.0, false);
    assertEquals("Sale{askingPrice=300000.0, negotiable=false}", sale.toString());
  }

  @Test
  public void testEquals() {
    Sale sale1 = new Sale(300000.0, false);
    Sale sale2 = new Sale(300000.0, false);
    Sale sale3 = new Sale(350000.0, true);

    assertEquals(sale1, sale2);
    assertNotEquals(sale1, sale3);
    assertNotEquals(sale2, sale3);
  }

  @Test
  public void testHashCode() {
    Sale sale1 = new Sale(300000.0, false);
    Sale sale2 = new Sale(300000.0, false);
    Sale sale3 = new Sale(350000.0, true);

    assertEquals(sale1.hashCode(), sale2.hashCode());
    assertNotEquals(sale1.hashCode(), sale3.hashCode());
  }

  @Test
  public void testCalculateCommission() {
    Sale sale = new Sale(300000.0, false);
    double commissionRate = 0.03;
    double expectedCommission = 0.03 * 300000.0;
    assertEquals(expectedCommission, sale.calculateCommission(commissionRate), 0.0001);
  }
}
