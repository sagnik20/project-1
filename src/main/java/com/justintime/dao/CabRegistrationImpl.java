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
		try {
			Session session = HibernateCon.getSession().openSession();
			tx = session.beginTransaction();
			
			session.save(c);
			
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
