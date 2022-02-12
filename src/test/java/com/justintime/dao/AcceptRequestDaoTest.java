/**
 * 
 */
package com.justintime.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sagnik
 *
 */
public class AcceptRequestDaoTest {

	/**
	 * @throws java.lang.Exception
	 */
	AcceptRequest ar = null;
	@Before
	public void setUp() throws Exception {
		ar = new AcceptRequestDao();
	}

	/**
	 * Test method for {@link com.justintime.dao.AcceptRequestDaoTest#acept(java.lang.Integer)}.
	 */
	@Test
	public void testAcept() {
		assertEquals(false,ar.acept(5));
	}

}
