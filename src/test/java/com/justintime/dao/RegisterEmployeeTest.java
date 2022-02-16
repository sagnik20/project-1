/**
 * 
 */
package com.justintime.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.justintime.model.Employee;

/**
 * @author Sagnik
 *
 */
public class RegisterEmployeeTest {

	/**
	 * @throws java.lang.Exception
	 */
	Employee emp = null;
	RegisterEmployee em = null;
	@Before
	public void setUp() throws Exception {
		emp = new Employee();
		em = new RegisterEmployeeImpl();
	}

	/**
	 * Test method for {@link com.justintime.dao.RegisterEmployeeImpl#register1(com.justintime.model.Employee)}.
	 */
	@Test
	public void testRegister1() {
		assertEquals(false,em.register1(emp));
		emp.setName("Apurb");
		assertEquals("Apurb",emp.getName());
		emp.setActive(1);
		emp.setDept("ABC");
		assertEquals("ABC",emp.getDept());
		emp.setEmail("apurb@emp.com");
		assertEquals("apurb@emp.com",emp.getEmail());
		emp.setPassword("Apurb @#$");
		assertEquals("Apurb @#$",emp.getPassword());
		//assertEquals(1,emp.getActive());
	}

}
