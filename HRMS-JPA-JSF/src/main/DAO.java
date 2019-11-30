package main;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAO {

	private static final String PERSISTENCE_UNIT = "hrmspu";
	private static EntityManager entitymanager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
	private static EntityTransaction transaction = entitymanager.getTransaction();
	
	public List<User> getAllUsersFromDB(){
		
		List<User> results = entitymanager.createQuery("SELECT u FROM user u").getResultList();
		for(int i = 0; i < results.size(); i++)
		{
			System.out.println(results.get(i).getId());
		}
		return results;
		
	}
}
