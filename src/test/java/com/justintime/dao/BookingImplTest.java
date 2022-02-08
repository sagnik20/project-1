/**
 * 
 */
package com.justintime.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author sagni
 *
 */
public class BookingImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	Booking b;
	@Before
	public void setUp() throws Exception {
		b = new BookingImpl();
	}

	/**
	 * Test method for {@link com.justintime.dao.BookingImpl#requestCab()}.
	 */
	@Test
	public void testRequestCab() {
		
		assertEquals(false,b.requestCab());
	}

}
