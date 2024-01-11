package com.refactor.practice;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {
  @org.junit.Test
  public void testStatement() {

    Movie movie1 = new Movie("电影1", Movie.NEW_RELEASE);
    Movie movie2 = new Movie("电影2", Movie.CHILDRENS);
    Movie movie3 = new Movie("电影3", Movie.REGULAR);


    Customer customer1 = new Customer("客户1");
    Customer customer2 = new Customer("客户2");

    //顾客租约
    Rental rental1 = new Rental(movie1, 10);
    Rental rental2 = new Rental(movie2, 1);
    Rental rental3 = new Rental(movie3, 3);
    customer1.addRental(rental1);
    customer1.addRental(rental2);
    customer2.addRental(rental2);
    customer2.addRental(rental3);

    Assert.assertEquals(customer1.statement(), "Rental Records for 客户1\n" +
        "\t电影1\t30.0\n" +
        "\t电影2\t1.5\n" +
        "Amount owed is 31.5\n" +
        "You earned 3 frequent renter points");
    Assert.assertEquals(customer2.statement(), "Rental Records for 客户2\n" +
        "\t电影2\t1.5\n" +
        "\t电影3\t3.5\n" +
        "Amount owed is 5.0\n" +
        "You earned 2 frequent renter points");
  }

}