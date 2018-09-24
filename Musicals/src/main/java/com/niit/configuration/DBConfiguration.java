package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.model.Authorities;
import com.niit.model.BillingAddress;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Customer;
import com.niit.model.CustomerOrder;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class DBConfiguration {
	
	public DBConfiguration(){
		System.out.println("DBConfiguration  bean is created ");
	}
	
	
	@Bean(name="database")
	public DataSource getDatasource()
	{
	
		System.out.println("Entering Datasource Bean creation method");
		
		BasicDataSource datasource= new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/rko");
		datasource.setUsername("rko");
		datasource.setPassword("17514322");
		System.out.println("Datasource bean"+datasource);
		return datasource;
	}


 @Bean
 public SessionFactory sessionFactory()
{
	 System.out.println("Entering SessionFactory Bean creation method");
	 LocalSessionFactoryBuilder lsf=new LocalSessionFactoryBuilder(getDatasource());
	 Properties hibernateProperties=new Properties();
	 hibernateProperties.setProperty(
			 "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	 hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
	 hibernateProperties.setProperty("hibernate.show_sql","true");
	 
	lsf.addProperties(hibernateProperties);
	
		 
	Class classes[]=new Class[]{Product.class,Category.class,Customer.class,User.class,Authorities.class,BillingAddress.class,ShippingAddress.class,CartItem.class,CustomerOrder.class};
System.out.println("SessionFactory bean"+lsf);
return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager hibTranaManagement()
	{
		return new HibernateTransactionManager(sessionFactory());
	
       }

	@Bean(name="productDao")
	public ProductDao getProductDao()
	{
		System.out.println("---Product DAO Implementation ---");
		return new ProductDaoImpl();
	}
	
}
	 
 
	



 