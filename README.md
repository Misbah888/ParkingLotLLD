# Parking Lot Management System

A simple **Parking Lot Management System** designed to demonstrate core **Low-Level Design (LLD)** and object-oriented design principles using Java.

## Features

- Park a vehicle
- Assign a compatible parking spot
- Generate a parking ticket
- Prevent duplicate parking for the same vehicle
- Remove a vehicle
- Calculate parking fees
- Display available parking spots
- Support different pricing strategies
- Support Cash and UPI payments

## Vehicle Types

- Bike
- Car

## Parking Spot Types

- Bike Spot
- Car Spot

A vehicle can only be parked in a compatible spot.

## Design Patterns Used

### 1. Strategy Pattern

Used for:

- Pricing
- Payment

Examples:

```text
PricingStrategy
├── BikePricingStrategy
└── CarPricingStrategy

PaymentStrategy
├── CashPayment
└── UpiPayment
```

This allows new pricing or payment methods to be added without modifying the main parking logic.

## LLD Concepts Demonstrated

- Encapsulation
- Abstraction
- Inheritance
- Polymorphism
- Composition / Association
- Interfaces
- SOLID principles
- Strategy Pattern
- Collections
- Exception-safe object interactions

## Project Structure

```text
src
├── vehicle
│   ├── Vehicle.java
│   ├── Bike.java
│   └── Car.java
│
├── parkingspot
│   ├── ParkingSpot.java
│   ├── BikeSpot.java
│   └── CarSpot.java
│
├── parkinglot
│   └── ParkingLot.java
│
├── ticket
│   ├── ParkingTicket.java
│   └── FeeCalculator.java
│
├── pricing
│   ├── PricingStrategy.java
│   ├── BikePricingStrategy.java
│   └── CarPricingStrategy.java
│
├── payment
│   ├── PaymentStrategy.java
│   ├── CashPayment.java
│   └── UpiPayment.java
│
└── Main.java
```

## Parking Flow

```text
Vehicle
   ↓
ParkingLot
   ↓
Find compatible available ParkingSpot
   ↓
Park Vehicle
   ↓
Generate ParkingTicket
   ↓
Vehicle exits
   ↓
Calculate Fee
   ↓
Remove Vehicle
   ↓
Process Payment
```

## Example

```java
ParkingLot parkingLot = new ParkingLot();

parkingLot.addParkingSpot(new BikeSpot(101));
parkingLot.addParkingSpot(new CarSpot(201));

Vehicle bike = new Bike("BIKE101");

ParkingTicket ticket = parkingLot.enterVehicle(bike);

double fee = parkingLot.exitVehicle("BIKE101");

parkingLot.processPayment(fee, new UpiPayment());
```

## Why This Design?

The project separates responsibilities between different classes:

- `Vehicle` represents vehicles.
- `ParkingSpot` manages parking spots.
- `ParkingLot` manages the overall parking operation.
- `ParkingTicket` represents a parking session.
- `FeeCalculator` calculates parking fees.
- `PricingStrategy` handles pricing rules.
- `PaymentStrategy` handles payment methods.

This keeps the design modular and makes it easier to extend.

## Future Extensions

Possible extensions include:

- Multiple parking floors
- More vehicle types
- More payment methods
- Different pricing rules
- Parking reservations
- Database persistence
- REST APIs

These features are intentionally outside the scope of the current implementation.

## Technologies

- Java
- Object-Oriented Programming
- Collections Framework
- Design Patterns
- IntelliJ IDEA
- Git / GitHub