import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResidentialTest {

  private Residential testResidential;
  private String testAddress;
  private Integer testSize, testSize2;
  private Integer testNumBedrooms;
  private Double testNumBathrooms;

  @BeforeEach
  void setUp() {
    testAddress = "123 Main St";
    testSize = 2000;
    testSize2 = -10;
    testNumBedrooms = 3;
    testNumBathrooms = 2.5;
    testResidential = new Residential(testAddress, testSize, testNumBedrooms, testNumBathrooms);
  }

  @Test
  void testConstructor_exception() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Residential(testAddress, testSize2, testNumBedrooms, testNumBathrooms);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Residential(testAddress, testSize, -1, testNumBathrooms);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Residential(testAddress, testSize, testNumBedrooms, -1.5);
    });
  }

  @Test
  void getAddress() {
    assertEquals(testAddress, testResidential.getAddress());
  }

  @Test
  void getSize() {
    assertEquals(testSize, testResidential.getSize());
  }

  @Test
  void getNumBedrooms() {
    assertEquals(testNumBedrooms, testResidential.getNumBedrooms());
  }

  @Test
  void getNumBathrooms() {
    assertEquals(testNumBathrooms, testResidential.getNumBathrooms());
  }

  @Test
  void testEquals() {
    assertTrue(testResidential.equals(testResidential));
    assertFalse(testResidential.equals(null));
    assertFalse(testResidential.equals("123test"));
    Residential test2 = new Residential("123test", testSize,testNumBedrooms, testNumBathrooms);
    assertFalse(testResidential.equals(test2));
    test2 = new Residential(testAddress, 1000, testNumBedrooms, testNumBathrooms);
    assertFalse(testResidential.equals(test2));
    test2 = new Residential(testAddress, testSize, 2, testNumBathrooms);
    assertFalse(testResidential.equals(test2));
    test2 = new Residential(testAddress, testSize, testNumBedrooms, 1.5);
    assertFalse(testResidential.equals(test2));
    test2 = new Residential(testAddress, testSize, 2, 1.5);
    assertFalse(testResidential.equals(test2));
    Residential test3 = new Residential(testAddress, testSize, testNumBedrooms, testNumBathrooms);
    assertTrue(testResidential.equals(test3));
  }

  @Test
  void testHashCode() {
    int expectHash = Objects.hash(Objects.hash(testAddress, testSize), testNumBedrooms, testNumBathrooms);
    assertEquals(expectHash, testResidential.hashCode());
  }
}