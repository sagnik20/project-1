package com.justintime.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.justintime.db.HibernateCon;
import com.justintime.model.Request;

/**
 * @author Sagnik
 *
 */
public class RequestPendingDaoImpl implements RequestPendingDao {

	@Override
	public List<Request> cabRequest() {
		Session session = HibernateCon.getSession().openSession();
		Query q=session.createQuery("select * from Request r where r.bid= 1"); //HQL

		List<Request> alist=q.list();
		session.close();
		return alist;
	}

	
}
