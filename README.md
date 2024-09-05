# Property Management System![img_1.png](img_1.png)

## Overview
This system is part of the backend for a property company website, similar to Redfin or Zillow. It manages various properties (residential and commercial), contracts (sales and rentals), listings, and real estate agents.

### Key Entities:
1. **Property**: Represents a real estate property with common attributes like address and size.
2. **Contract**: Represents a sales or rental agreement associated with a property.
3. **Listing**: Combines a property and its associated contract.
4. **Agent**: A person who manages listings and earns commission based on sales or rentals.

## Table of Contents
- [Features](#features)
- [Classes](#classes)
- [Usage](#usage)

## Features
- Supports managing **residential** and **commercial** properties.
- Supports creating **sales** and **rental** contracts.
- Allows **agents** to add, complete, and drop property listings.
- Calculates **commission** based on agent’s listings and contract type.
- Provides a **portfolio value** for agents based on their current listings.

## Classes
The system is built using several core classes, each with specific responsibilities:

### Property
- **Attributes**:
    - `address` (String): The property's address.
    - `size` (Integer): The property's size in square feet.

### Residential
- Inherits from `Property`.
- **Attributes**:
    - `numBedrooms` (Integer): The number of bedrooms.
    - `numBathrooms` (Double): The number of bathrooms (supports half-baths).

### Commercial
- Inherits from `Property`.
- **Attributes**:
    - `numOffices` (Integer): The number of offices.
    - `retailable` (Boolean): Indicates if the property is suitable for retail.

### Contract
- **Attributes**:
    - `askingPrice` (Double): The asking price for the property.
    - `negotiable` (Boolean): Indicates if the price is negotiable.

### Sale
- Inherits from `Contract`.
- Used to represent a sale contract.

### Rental
- Inherits from `Contract`.
- **Attributes**:
    - `term` (Integer): The rental term in months.

### Listing\<P, C\>
- A generic class that combines a **property (P)** and a **contract (C)**.
- **Attributes**:
    - `property` (P): The property being listed.
    - `contract` (C): The contract associated with the listing.

### Agent\<P, C\>
- A generic class for real estate agents who manage listings.
- **Attributes**:
    - `name` (String): The agent's name.
    - `listings` (List\<Listing<P, C>\>): A collection of current listings the agent manages.
    - `commissionRate` (Double): The agent’s commission rate.
    - `totalEarnings` (Double): The total amount the agent has earned from completed listings.

- **Methods**:
    - `addListing(Listing<P, C>)`: Adds an appropriate listing to the agent’s collection.
    - `completeListing(Listing<P, C>)`: Completes the sale/rental and updates the agent’s earnings.
    - `dropListing(Listing<P, C>)`: Drops a listing without adjusting the agent’s earnings.
    - `getTotalPortfolioValue()`: Returns the total value of all active listings if they were completed.

### ListingNotFoundException
- A custom exception thrown when a requested listing is not found in the agent's collection.

## Usage

### Adding Listings
To add a listing to an agent’s portfolio:
```java
Agent<Residential, Sale> agent = new Agent<>(0.05, "John Smith", new ArrayList<>());
Residential residential = new Residential("123 Main St", 2000, 3, 2.5);
Sale sale = new Sale(500000, true);
Listing<Residential, Sale> listing = new Listing<>(residential, sale);
agent.addListing(listing);
```

### Completing a Listing
To mark a listing as completed and update the agent’s earnings:
```java
agent.completeListing(listing);
```

### Dropping a Listing
To remove a listing from an agent’s portfolio:
```java
agent.dropListing(listing);
```

### Calculating Total Portfolio Value
To get the total value of an agent’s current portfolio:
```java
double value = agent.getTotalPortfolioValue();
```

