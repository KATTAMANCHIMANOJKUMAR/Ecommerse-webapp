package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Authorities;
import com.niit.model.Customer;
import com.niit.model.User;

@Repository

@Transactional
public class CustomerDaoImpl implements CustomerDao {
        @Autowired
        private SessionFactory sessionFactory;
	public void registerCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		
		
		//set Enabled property in user as true.
		customer.getUser().setEnabled(true); //to make user object to refer that Authorities object(newly created object).
		
		System.out.println(customer.getUser().getAuthorities());
		
		
		//create new authorities object and set the role_user
		//Authorities property in user refers to Authorities object
		Authorities authorities=new Authorities();
		authorities.setRole("ROLE_USER");
		authorities.setUser(customer.getUser());
		//We want to set the user property in Authorities to refer this user object.
		customer.getUser().setAuthorities(authorities);
		
		 //MAKE USER PROPERTY IN AUTHORITIES TO REFER USER OBJECT
		   authorities.setUser(customer.getUser());
		
		session.save(customer);
		//has to insert into customer table.
		
	}
	public boolean isEmailUnique(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,email);
		if(user==null) //email is unique
			return true;
		else 
		
		return false; //email is not unique
	}

}
