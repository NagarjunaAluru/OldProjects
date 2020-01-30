package com.galaxe.gst.dao.login;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.galaxe.gst.models.login.Users;

/**
 * 
 * @author naluru
 *
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public Users findByUserName(String username) {
		session = sessionFactory.openSession();
		 tx=session.beginTransaction();
		 Criteria c1 = session.createCriteria(Users.class);
		 c1.add(Restrictions.eq("username",username));
		 
		 @SuppressWarnings("unchecked")
		List<Users> list = (List<Users>)c1.list();
		return list.get(0);
	}

}
