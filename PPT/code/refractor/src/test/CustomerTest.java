package test;

import static org.junit.Assert.*;

import org.junit.Test;

import refractor.Customer;
import refractor.Movie;
import refractor.Rental;

public class CustomerTest {

	@Test
	public void testCustomer() {
		Customer c = new Customer("An");
		assertEquals(c.getName(), "An");
	}

	@Test
	public void testAddRental() {
		Customer c = new Customer("An");
		c.addRental(new Rental(new Movie("mov1", Movie.REGULAR), 2));
		c.addRental(new Rental(new Movie("mov2", Movie.NEW_RELEASE), 3));
		c.addRental(new Rental(new Movie("mov2", Movie.CHILDRENS), 4));
		
	}

	@Test
	public void testGetName() {
		Customer c = new Customer("An");
		assertEquals(c.getName(), "An");
	}

	@Test
	public void testStatement() {
		Customer c = new Customer("An");
		c.addRental(new Rental(new Movie("mov1", Movie.REGULAR), 2));
		c.addRental(new Rental(new Movie("mov2", Movie.NEW_RELEASE), 3));
		c.addRental(new Rental(new Movie("mov3", Movie.CHILDRENS), 4));
		
		assertEquals("Rental Record for An\n\tmov1\t2.0\n\tmov2\t9.0\n\tmov3\t3.0\nAmount owed is 14.0\nYou earned 4 frequent reter points", c.statement());
	}

}
