import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Yitian Xu
 * This class represents an agent.
 * @param <P>
 * @param <C>
 */
public class Agent<P extends Property, C extends Contract> {
  private String name;
  private List<Listing<P, C>> listings;
  private double commissionRate;
  private double totalEarnings;
  private static final Double LOWER_BOUND_FOR_COMMISSION_RATE = 0.0;
  private static final Double HIGHER_BOUND_FOR_COMMISSION_RATE = 1.0;
  /**
 * Constructs a new Agent object with the given parameters.
 *
 * @param commissionRate The commission rate for the agent, which must be between 0 and 1 (inclusive).
 * @param listings The list of listings associated with the agent.
 * @param name The name of the agent.
 * @param totalEarnings The total earnings of the agent. Must be a non-negative value.
 * @throws IllegalArgumentException If the commission rate is not within the valid range or if total earnings is negative.
 */
public Agent(double commissionRate, List<Listing<P, C>> listings, String name,
      double totalEarnings) throws IllegalArgumentException{
    if (commissionRate < LOWER_BOUND_FOR_COMMISSION_RATE || commissionRate > HIGHER_BOUND_FOR_COMMISSION_RATE) {
      throw new IllegalArgumentException("Commission rate must be between 0 and 1.");
    }
    if (totalEarnings < 0) throw new IllegalArgumentException("Total Earnings must be be larger than zero.");
    this.commissionRate = commissionRate;
    this.listings = listings;
    this.name = name;
    this.totalEarnings = totalEarnings;
  }

  /**
   * Add a listing to the list of listings
   * @param listing
   */
  void addListing(Listing<P, C> listing) {
    listings.add(listing);
  }


  /**
 * Completes a listing by calculating the commission earned and adding it to the total earnings.
 *
 * @param listing The listing to be completed. It must be associated with the agent.
 * @throws ListingNotFoundException If the listing is not found in the agent's collection.
 */
public void completeListing(Listing<P, C> listing) throws ListingNotFoundException {
    Double add = singleListValueCalculator(listing);
    this.setTotalEarnings(this.getTotalEarnings() + add);
}

  /**
 * Removes a listing from the agent's collection of listings.
 *
 * @param listing The listing to be removed. It must be associated with the agent.
 * @throws ListingNotFoundException If the listing is not found in the agent's collection.
 */
public void dropListing(Listing<P, C> listing) throws ListingNotFoundException {
    if (!listings.remove(listing)) {
      throw new ListingNotFoundException("Listing not found in agent's collection.");
    }
}

  /**
 * Calculates the total value of all listings associated with the agent.
 * The total value is calculated by summing the individual values of each listing,
 * which are determined by the {@link #singleListValueCalculator(Listing)}.
 *
 * @return The total value of all listings associated with the agent.
 * @throws ListingNotFoundException If a listing associated with the agent is not found.
 */
public double getTotalPortfolioValue() throws ListingNotFoundException {
    double totalValue = this.getTotalEarnings();
    int sz = this.getListings().size();
    for(int i = 0; i < sz; i++) {
      totalValue += singleListValueCalculator(this.getListings().get(i));
    }
    return totalValue;
}

/**
 * Calculates the commission earned from a single listing based on the type of contract and the agent's commission rate.
 *
 * @param listing The listing for which the commission is to be calculated. It must be associated with the agent.
 * @return The commission earned from the given listing.
 * @throws ListingNotFoundException If the listing is not found in the agent's collection.
 */
public double singleListValueCalculator(Listing<P, C> listing) throws ListingNotFoundException {
    if (!listings.remove(listing)) {
      throw new ListingNotFoundException("Listing not found in agent's collection.");
    }

    return (listing.getContract()).calculateCommission(this.commissionRate);
  }

  /**
   * Calculates the commission rate
   * @return
   */
  public double getCommissionRate() {
    return commissionRate;
  }

  /**
   * set the commission rate
   * @param commissionRate
   */
  public void setCommissionRate(double commissionRate) {
    this.commissionRate = commissionRate;
  }

  /**
   * get the listings
   * @return
   */
  public List<Listing<P, C>> getListings() {
    return listings;
  }

  /**
   * set the listings
   * @param listings
   */
  public void setListings(List<Listing<P, C>> listings) {
    this.listings = listings;
  }

  /**
   * get the name of agent
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * set the name of agent
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * get the total earning of agent
   * @return
   */
  public double getTotalEarnings() {
    return totalEarnings;
  }

  /**
   * set the total earning of agent
   * @param totalEarnings
   */
  public void setTotalEarnings(double totalEarnings) {
    this.totalEarnings = totalEarnings;
  }

  /**
   * Equals method
   * @param o
   * @return
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Agent<?, ?> agent = (Agent<?, ?>) o;
    return Double.compare(commissionRate, agent.commissionRate) == 0
        && Double.compare(totalEarnings, agent.totalEarnings) == 0
        && Objects.equals(name, agent.name) && Objects.equals(listings,
        agent.listings);
  }

  /**
   * Hashcode
   * @return
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, listings, commissionRate, totalEarnings);
  }

  /**
   * toString
   * @return
   */
  @Override
  public String toString() {
    return "Agent{" +
        "commissionRate=" + commissionRate +
        ", name='" + name + '\'' +
        ", listings=" + listings +
        ", totalEarnings=" + totalEarnings +
        '}';
  }
}
