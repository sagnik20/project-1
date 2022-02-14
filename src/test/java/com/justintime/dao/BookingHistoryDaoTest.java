/**
 * 
 */
package com.justintime.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sagnik
 *
 */
public class BookingHistoryDaoTest {

	/**
	 * @throws java.lang.Exception
	 */
	BookingHistoryDao bh = null;
	@Before
	public void setUp() throws Exception {
		bh = new BookingHistoryDaoImpl();
	}

	/**
	 * Test method for {@link com.justintime.dao.BookingHistoryDaoImpl#bookingHistory(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testBookingHistory() {
		List alist =null;
		assertEquals(alist,bh.bookingHistory("abc@emp.com", "abc123"));
	}

}
