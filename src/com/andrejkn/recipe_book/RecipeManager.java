package com.andrejkn.recipe_book;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.andrejkn.recipe_book.models.Recipe;

public class RecipeManager {
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
		
		RecipeManager rm = new RecipeManager();
		rm.addRecipe("Sarma", "Grind meat, rolled in sour cabage leafs.");
	}
	
	public Integer addRecipe(String title, String description) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer recipeID = null;
		
		try {
			tx = session.beginTransaction();
			
			Recipe recipe = new Recipe(title, description);
			recipeID = (Integer) session.save(recipe);
			tx.commit();
			
		} catch(HibernateException e) {
			if(tx != null) tx.rollback();
		} finally {
			session.close();
		}
		
		return recipeID;
	}
}