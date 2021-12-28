package com.revature.cookbook.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.revature.cookbook.model.Cookbook;

@Repository
public class CookbookDao {
	
	@PersistenceContext
	private EntityManager em;
	
	Logger logger = LoggerFactory.getLogger(CookbookDao.class); 

	@Transactional
	public Cookbook createNewCookbook(Cookbook createdCookbook) {
		em.persist(createdCookbook);
		
		logger.info("COOKBOOK DAO: Got cookbook " + createdCookbook);
		
		return createdCookbook;
	}

	@Transactional
	public Cookbook getCookbookById(int cookbookId) {
		
		Session session = em.unwrap(Session.class);
		
		Cookbook cookbook = session.get(Cookbook.class, cookbookId);
		
		logger.info("COOKBOOK DAO: Got cookbook with id of " + cookbookId + " " + cookbook);
		
		return cookbook; 
		
	}

	@Transactional
	public void addRecipeToCookbook(Cookbook cookbook, int recipeId) {
		
		cookbook.setRecipeIds(cookbook.getRecipeIds() + " " + recipeId);
		
	}

}
