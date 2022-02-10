package com.justintime.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.justintime.db.HibernateCon;
import com.justintime.model.Request;

/**
 * @author Sagnik
 *
 */
public class RequestPendingDaoImpl implements RequestPendingDao {

	@Override
	public List cabRequest() {
		Session session = HibernateCon.getSession().openSession();
		List alist = null;
		try {
			SQLQuery q=session.createSQLQuery("select * from request as r where r.bid= 1"); //HQL
			q.addEntity(Request.class);
			alist = q.list();
		} 
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return alist;
	}

	
}
