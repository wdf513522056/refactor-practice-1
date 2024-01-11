package com.refactor.practice;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
  private String name;
  private Vector<Rental> rentals = new Vector<>();

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPointers = 0;
    Enumeration<Rental> rentalEnumeration = rentals.elements();
    String result = "Rental Records for " + getName() + "\n";

    while (rentalEnumeration.hasMoreElements()) {
      double thisAmount = 0;
      Rental each = rentalEnumeration.nextElement();

      thisAmount = amountForRental(each);

      // add frequent renter points
      frequentRenterPointers++;
      // add bonus for two day new release rental
      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
        frequentRenterPointers++;
      }

      //show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
      totalAmount += thisAmount;
    }

    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentRenterPointers + " frequent renter points";
    return result;
  }

  private double amountForRental(Rental aRental) {
    return aRental.getOneRentalAmount();
  }
}
