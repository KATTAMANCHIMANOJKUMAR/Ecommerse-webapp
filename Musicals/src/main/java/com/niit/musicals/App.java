package com.niit.musicals;


import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfiguration;
import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.model.Product;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class);
        context.scan("com.niit");
        //context.refresh();
        ProductDao productDao=(ProductDao)context.getBean("productDao");
        List<Product> products=productDao.getAllProducts();

       for(Product p:products){
        System.out.println(p.getId() + " "+ p.getProductname()+" " +p.getProductdescription()+" "+ p.getPrice()+""+p.getQuantity());
       
        
        //productDao.getProduct(116);
    }
}
}

        
        
        
        
      
        	
        