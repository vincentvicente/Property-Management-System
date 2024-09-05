import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgentTest {

  Rental rental, rental2;
  Sale sale;
  Residential residential, residential2;
  Listing<Residential, Rental> listing, listing2;
  Listing<Residential, Sale> listing3;
  ArrayList<Listing<Residential, Rental>> listForListing;

  Agent agent;
  @BeforeEach
  public void setup() {

    rental = new Rental(2000.0, true, 12);
    rental2 = new Rental(21000.0, true, 12);
    sale = new Sale(300000.0, false);
    residential = new Residential("456 Elm St", 1500, 3, 2.5);
    residential = new Residential("test 2 Elm St", 300, 13, 2.5);
    listing = new Listing<>(residential, rental);
    listing2 = new Listing<>(residential2, rental2);
    listing3 = new Listing<>(residential, sale);
    listForListing = new ArrayList<>();
    agent = new Agent(0.5, listForListing, "John Doe", 0);
  }

  @Test
  void addListing() {
    agent.addListing(listing2);
    assertEquals(1, agent.getListings().size());
    agent.addListing(listing);
    assertEquals(2, agent.getListings().size());

  }

  @Test
  void completeListing() throws ListingNotFoundException {
    agent.addListing(listing);
    agent.completeListing(listing);
    double expected = 0.5 * 2000 * 12 ;
    assertEquals(expected, agent.getTotalEarnings());
    assertThrows(ListingNotFoundException.class, () -> agent.completeListing(listing));
  }
 @Test
  void completeListing2() throws ListingNotFoundException {
    agent.addListing(listing3);
    agent.completeListing(listing3);
    double expected = 0.5 * 300000;
    assertEquals(expected, agent.getTotalEarnings());
    assertThrows(ListingNotFoundException.class, () -> agent.completeListing(listing));
  }

  @Test
  void completeListing3() throws ListingNotFoundException {
    boolean flag = false;
    try{
      Agent agent2 = new Agent(-1, null, "Mac Stupod", 0);
    } catch(IllegalArgumentException e) {flag = true;}
    assertTrue(flag);
  }

  @Test
  void completeListing4() throws ListingNotFoundException {
    boolean flag = false;
    try{
      Agent agent3 = new Agent(11, null, "Mac Stupod", 0);
    } catch(IllegalArgumentException e) {flag = true;}
    assertTrue(flag);
  }


  @Test
  void dropListing() throws ListingNotFoundException {
    agent.addListing(listing);
    agent.dropListing(listing);
    assertEquals(0, agent.getListings().size());
    assertThrows(ListingNotFoundException.class, () -> agent.dropListing(listing));
  }



  @Test
  void getTotalPortfolioValue() throws ListingNotFoundException {
    agent.addListing(listing);
    double result = agent.getTotalPortfolioValue();
    double expected = 0.5 * 2000 * 12;
    assertEquals(expected, result);
  }

  @Test
  void singleListValueCalculator() throws ListingNotFoundException{
    agent.addListing(listing);
    double expected = 0.5 * 2000 * 12;
    assertEquals(expected, agent.singleListValueCalculator(listing));
  }

  @Test
  void getCommissionRate() {
    assertEquals(0.5, agent.getCommissionRate());
  }

  @Test
  void setCommissionRate() {
    agent.setCommissionRate(0.7);
    assertEquals(0.7, agent.getCommissionRate());
  }

  @Test
  void getListings() {
    assertEquals(0, agent.getListings().size());
  }

  @Test
  void setListings() {
    ArrayList<Listing<Residential, Rental>> listForListing2 = new ArrayList<>();
    listForListing2.add(listing);
    agent.setListings(listForListing2);
    assertEquals(1, agent.getListings().size());
  }

  @Test
  void getName() {
    assertEquals("John Doe", agent.getName());
  }

  @Test
  void setName() {
    agent.setName("Jane Doe");
    assertEquals("Jane Doe", agent.getName());
  }

  @Test
  void getTotalEarnings() throws ListingNotFoundException {
    assertEquals(0, agent.getTotalEarnings());
    agent.addListing(listing);
    agent.completeListing(listing);
    assertEquals(0.5 * 2000 * 12, agent.getTotalEarnings());
  }

  @Test
  void setTotalEarnings() {
    agent.setTotalEarnings(1000);
    assertEquals(1000, agent.getTotalEarnings());
  }
}