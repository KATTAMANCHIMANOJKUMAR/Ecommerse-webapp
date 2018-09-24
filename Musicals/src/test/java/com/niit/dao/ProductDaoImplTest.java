package com.niit.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguration;
import com.niit.model.Product;

import junit.framework.TestCase;

public class ProductDaoImplTest extends TestCase {
	 ApplicationContext context=new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
     ProductDao productDao=(ProductDao)context.getBean("productDaoImpl");

	public void testSaveProduct() {
		
		Product product=new Product();
		
		product.setPrice(50000);
		product.setQuantity(1);
		product.setProductname("guitar");
		product.setProductdescription("black colour style type guitar");
		product=productDao.saveProduct(product);
		assertTrue(product.getId()>0);
		
		
		
		
		
		
	
	}

	public void testGetProduct() {
		Product product1=productDao.getProduct(3);
		Product product2=productDao.getProduct(9);
		
		assertNotNull(product1);
		assertNull(product2);
		
		
		double expectedPrice=100;
		double actualPrice=100;
		assertTrue(expectedPrice==actualPrice);
	  
	}
	
	
public void testUpdateProduct() {
	
	Product product=productDao.getProduct(3);
	product.setPrice(200);
	product.setQuantity(20);
	
	productDao.updateProduct(product);
	
	assertTrue(product.getPrice()==200);
	assertTrue(product.getQuantity()==20);
		
	}
	
	public void testGetAllProducts()
	{
		List<Product> products=productDao.getAllProducts();
		
		assertTrue(products.size()>0);
		assertFalse(products.isEmpty());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
