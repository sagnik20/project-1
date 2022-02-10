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
public class RejectRequestDao implements RejectRequest {

	@Override
	public boolean rejct(Integer id) {
		Session session = HibernateCon.getSession().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Request r = (Request) session.get(Request.class, id);
			BookingStatus cs = new BookingStatus(3,"Rejected");
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
