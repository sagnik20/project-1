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
		Transaction tx=null;
		try {
			Session session = HibernateCon.getSession().openSession();
			tx = session.beginTransaction();
			BookingStatus b = new BookingStatus(1,"Requested");
			for(Employee e : ValidateUser.elist) {
			Request rq = new Request(e,b);
			session.save(rq);
			}

			   
			tx.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			if (tx != null) {
                tx.rollback();
            }
			e.printStackTrace();
		}
		return false;
	}

}
