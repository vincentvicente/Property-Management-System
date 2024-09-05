import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommercialTest {
  private Commercial testCommercial;
  private String testAddress;
  private Integer testSize;
  private Integer testNumOffices;
  private Boolean testRetailable;

  @BeforeEach
  void setUp() {
    testAddress = "123 Main St";
    testSize = 2000;
    testNumOffices = 3;
    testRetailable = true;
    testCommercial = new Commercial(testAddress, testSize, testNumOffices, testRetailable);
  }

  @Test
  void testConstructor_exception() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Commercial(testAddress, testSize, -1, testRetailable);
    });
  }

  @Test
  void getNumOffices() {
    assertEquals(testNumOffices, testCommercial.getNumOffices());
  }

  @Test
  void getRetailable() {
    assertEquals(testRetailable, testCommercial.getRetailable());
  }

  @Test
  void testEquals() {
    assertTrue(testCommercial.equals(testCommercial));
    assertFalse(testCommercial.equals(null));
    assertFalse(testCommercial.equals("123test"));
    Commercial commercial2 = new Commercial(testAddress, testSize, testNumOffices, testRetailable);
    assertTrue(testCommercial.equals(commercial2));
    commercial2 = new Commercial(testAddress, testSize, 2, testRetailable);
    assertFalse(testCommercial.equals(commercial2));
    commercial2 = new Commercial("123test", testSize, testNumOffices, testRetailable);
    assertFalse(testCommercial.equals(commercial2));
    commercial2 = new Commercial(testAddress, 1000, testNumOffices, testRetailable);
    assertFalse(testCommercial.equals(commercial2));
    commercial2 = new Commercial(testAddress, testSize, testNumOffices,false);
    assertFalse(testCommercial.equals(commercial2));
  }

  @Test
  void testHashCode() {
    int expectHash = Objects.hash(Objects.hash(testAddress, testSize), testNumOffices, testRetailable);
    assertEquals(expectHash, testCommercial.hashCode());
  }
}