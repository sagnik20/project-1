/**
 * 
 */
package com.justintime.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.justintime.model.Cab;

/**
 * @author sagni
 *
 */
public class CabRegistrationTest {

	/**
	 * @throws java.lang.Exception
	 */
	Cab c = null;
	Cab c1 = null;
	CabRegister cr = null;
	@Before
	public void setUp() throws Exception {
		c = new Cab();
		c1 = new Cab(3524,1,"ABC","6584721365");
		cr = new CabRegistrationImpl();
	}

	/**
	 * Test method for {@link com.justintime.dao.CabRegistrationImpl#register(com.justintime.model.Cab)}.
	 */
	@Test
	public void testRegister() {
		assertEquals(true,cr.register(c1));
		assertEquals(false,cr.register(c));
	}

}
