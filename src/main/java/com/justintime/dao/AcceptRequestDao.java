/**
 * 
 */
package com.justintime.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.db.HibernateCon;
import com.justintime.model.BookingStatus;
import com.justintime.model.Request;

/**
 * @author sagni
 *
 */
public class AcceptRequestDao implements AcceptRequest {

	@Override
	public boolean acept(Integer id) {
		Session session = HibernateCon.getSession().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Request r = (Request) session.get(Request.class, id);
			BookingStatus cs = new BookingStatus(2,"Accepted");
			r.setbId(cs);
			session.update(r);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
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
