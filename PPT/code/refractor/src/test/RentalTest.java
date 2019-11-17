package test;

import static org.junit.Assert.*;

import org.junit.Test;

import refractor.Movie;
import refractor.Rental;

public class RentalTest {

	@Test
	public void testRental() {
		Rental rt = new Rental(new Movie("myMovie", 2), 3);
		assertEquals(rt.getMovie().getTitle(), "myMovie");
		assertEquals(rt.getMovie().getPriceCode(), 2);
		assertEquals(rt.getDaysRented(), 3);
	}

	@Test
	public void testGetDaysRented() {
		Rental rt = new Rental(new Movie("myMovie", 2), 3);
		assertEquals(rt.getDaysRented(), 3);
	}

	@Test
	public void testGetMovie() {
		Rental rt = new Rental(new Movie("myMovie", 2), 3);
		assertEquals(rt.getMovie().getTitle(), "myMovie");
		assertEquals(rt.getMovie().getPriceCode(), 2);
	}

}
