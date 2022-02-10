package com.justintime.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.db.HibernateCon;
import com.justintime.model.BookingDetails;

/**
 * @author Sagnik
 *
 */
public class BookingHistoryDaoImpl implements BookingHistoryDao{

	public List bookingHistory(String email, String pass) {
		Session session = HibernateCon.getSession().openSession();
		List alist=null;
		try {
			String sql = "Select b.bookingId,b.cabNo,e.id from bdetails b, employee e where e.email="+ email+" and b.id=e.id";
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity(BookingDetails.class);
			alist = q.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return alist;
	}

}
