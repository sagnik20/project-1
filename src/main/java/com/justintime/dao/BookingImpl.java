package com.justintime.dao;

import org.hibernate.HibernateException;

/**
 * @author Sagnik
 *
 */

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.db.HibernateCon;
import com.justintime.model.BookingStatus;
import com.justintime.model.Employee;
import com.justintime.model.Request;

public class BookingImpl implements Booking{

	public boolean requestCab() {

		Session session = HibernateCon.getSession().openSession();
		Transaction tx=null;
		
		try {
			tx = session.beginTransaction();
			BookingStatus b = new BookingStatus(1,"Requested");
			for(Employee e : ValidateUser.elist) {
			Request rq = new Request(e,b);
			session.save(rq);
			}
			   
			tx.commit();
			
			return true;
		} catch (HibernateException e) {
			if (tx != null) {
                tx.rollback();
            }
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

}
