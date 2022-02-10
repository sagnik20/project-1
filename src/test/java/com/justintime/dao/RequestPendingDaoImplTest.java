package com.justintime.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sagnik
 *
 */
public class RequestPendingDaoImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	RequestPendingDaoImpl r;
	@Before
	public void setUp() throws Exception {
		r = new RequestPendingDaoImpl();
	}

	/**
	 * Test method for {@link com.justintime.dao.RequestPendingDaoImpl#cabRequest()}.
	 */
	@Test
	public void testCabRequest() {
		List l = r.cabRequest();
		//System.out.println(l.get(0).toString());
		assertEquals(null,l); //test should fail
	}

}
