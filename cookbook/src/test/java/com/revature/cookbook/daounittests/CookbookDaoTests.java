package com.revature.cookbook.daounittests;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.annotation.Transactional;

import com.revature.cookbook.dao.CookbookDao;
import com.revature.cookbook.model.Cookbook;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CookbookDaoTests {

	
	@Autowired 
	private EntityManager em;
	
	@Autowired
	private CookbookDao cookbookDaoSut; 
	
	@Test
	@Transactional
	public void createCookbookPositive() {
		
		Cookbook cookbook = new Cookbook();
		cookbook.setLikes(5);
		cookbook.setName("testname");
		
		Cookbook expectedCookbook = cookbookDaoSut.createNewCookbook(cookbook);
		
		Assertions.assertEquals(expectedCookbook, cookbook);
		
		
		
	}
	
	@Test
	@Transactional
	public void getCookbookByIdPositive() {
		
		Cookbook cookbook = new Cookbook();
		cookbook.setName("test");
		
		em.persist(cookbook);
		em.flush();
		
		Assertions.assertEquals(cookbook, cookbookDaoSut.getCookbookById(cookbook.getId()));
		
	}
	
	@Test
	@Transactional
	public void getCookbookByIdNoCookbookWithIdNegative() {
		
		Assertions.assertEquals(null, cookbookDaoSut.getCookbookById(9999));
		
	}
	
	@Test
	@Transactional
	public void addRecipeToCookbookPositive() {
		
		Cookbook cookbook = new Cookbook();
		
		em.persist(cookbook);
		em.flush();
		
		cookbookDaoSut.addRecipeToCookbook(cookbook, 5);
		
		Assertions.assertEquals(" 5", cookbook.getRecipeIds());
		
	}
	
	
}
