package test;

import static org.junit.Assert.*;

import org.junit.Test;

import refractor.Movie;

public class MovieTest {

	@Test
	public void testMovie() {
		Movie m = new Movie("myMovie", 2);
		assertEquals(m.getTitle(), "myMovie");
		assertEquals(m.getPriceCode(), 2);
	}

	@Test
	public void testGetPriceCode() {
		Movie m = new Movie("myMovie", 2);
		assertEquals(m.getPriceCode(), 2);
	}

	@Test
	public void testSetPriceCode() {
		Movie m = new Movie("myMovie", 2);
		m.setPriceCode(3);
		assertEquals(m.getPriceCode(), 3);
	}

	@Test
	public void testGetTitle() {
		Movie m = new Movie("myMovie", 2);
		assertEquals(m.getTitle(), "myMovie");
	}

}
