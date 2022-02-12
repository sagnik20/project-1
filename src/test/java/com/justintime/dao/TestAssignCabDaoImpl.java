package com.justintime.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sagnik
 *
 */
public class TestAssignCabDaoImpl {
	
	AssignCabDao ac = null;

	@Before
	public void setUp() throws Exception {
		ac = new AssignCabDaoImpl();
	}

	@Test
	public void testAssign() {
		assertEquals(false,ac.assign(4));
	}

}
