package com.justintime.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.db.HibernateCon;
import com.justintime.model.BookingDetails;

/**
 * @author Sagnik
 *
 */
public class BookingHistoryDaoImpl implements BookingHistoryDao{

	public List<BookingDetails> bookingHistory(String email, String pass) {
		Session session = HibernateCon.getSession().openSession();
		Query q=session.createQuery("Select b.bookingId,b.cabNo,e.id from BookingDetails b, Employee e where e.email= :email and b.id=e.id")
				.setParameter("email", email); //HQL

		List<BookingDetails> alist=q.list();
		session.close();
		return alist;
	}

}
