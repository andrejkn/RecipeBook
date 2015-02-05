package com.andrejkn.recipe_book;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.andrejkn.recipe_book.models.Nutrient;

public class NutrientManager {
	private static SessionFactory factory;
	private static StandardServiceRegistryBuilder serviceRegistryBuilder;

	public static void main(String[] args) {
		try{
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			
			serviceRegistryBuilder = new StandardServiceRegistryBuilder();  
			StandardServiceRegistry serviceRegistry = 
					serviceRegistryBuilder.applySettings(config.getProperties()).build();
			
			factory =  config.buildSessionFactory(serviceRegistry); 
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}
		
		NutrientManager nm = new NutrientManager();
		nm.addNutrient(NutrientType.CARBOHYDRATE, 2.34);
	}
	
	public Integer addNutrient(NutrientType type, double amount) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer nutrientID = null;
		
		try {
			tx = session.beginTransaction();
			
			Nutrient nutrient = new Nutrient(type, amount);
			nutrientID = (Integer) session.save(nutrient);
			tx.commit();
			
		} catch(HibernateException e) {
			if(tx != null) tx.rollback();
		} finally {
			session.close();
		}
		
		return nutrientID;
	}
}
