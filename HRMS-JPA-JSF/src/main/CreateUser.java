package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import main.User;

public class CreateUser {

	
		public static void main(String args[]) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HRMSPU");
		EntityManager entitymanager = emfactory.createEntityManager();
		
		entitymanager.getTransaction().begin();
		
		User user = new User();
		
		user.setUsername("person");
		user.setPassword("passcode");
		user.setEmail("email@email.com");
		
		entitymanager.persist(user);
		entitymanager.getTransaction().commit();
		
		entitymanager.close( );
	    emfactory.close( );
		}
	}
	
	

   
    
    

