package com.justintime.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.justintime.db.HibernateCon;
import com.justintime.model.Employee;

public class RegisterEmployeeImpl implements RegisterEmployee{

	public Boolean register1(Employee emp) {
		Session session = HibernateCon.getSession().openSession();
		Transaction  tx = null;
		try {
			
			tx = session.beginTransaction();
			if(emp!=null)
				session.save(emp);
			else
				throw new Exception();
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			//e.printStackTrace();
			return false;
		}finally {
			session.close();
		}

		return true;
	}



}
