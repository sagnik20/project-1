package com.justintime.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.db.HibernateCon;
import com.justintime.model.Cab;

/**
 * @author Sagnik
 *
 */
public class CabRegistrationImpl implements CabRegister{

	public boolean register(Cab c) {
		Transaction tx=null;
		Session session = HibernateCon.getSession().openSession();
		try {
			tx = session.beginTransaction();
			
			session.save(c);
			
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			session.close();
		}
		return true;
	}

}
