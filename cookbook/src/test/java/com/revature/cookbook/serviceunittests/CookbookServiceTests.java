package com.revature.cookbook.serviceunittests;

import static org.mockito.Mockito.when;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.annotation.Transactional;

import com.revature.cookbook.dao.CookbookDao;
import com.revature.cookbook.dao.UserDao;
import com.revature.cookbook.model.Cookbook;
import com.revature.cookbook.model.User;
import com.revature.cookbook.service.CookbookService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class CookbookServiceTests {

	@Mock
	private CookbookDao cookbookDao; 
	
	@Mock
	private UserDao userDao;
	
	@InjectMocks
	@Resource
	private CookbookService cookbookServiceSut;
	

	
	private String longString = "lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll"
			+ "lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll"
			+ "lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll";
	
	@BeforeEach
	public void setup() {
		
		cookbookServiceSut = new CookbookService();
		MockitoAnnotations.openMocks(this);
		
	}
	
	@Test
	public void getCookbookWithIdPositive() {
		
		Cookbook cookbook = new Cookbook();
		cookbook.setName("test");
		
		when(cookbookDao.getCookbookById(1)).thenReturn(cookbook);
		
		Assertions.assertEquals(cookbook, cookbookServiceSut.getCookbook(1));
		
	}
	
	@Test
	public void getCookbookWithIdCookbookDoesntExistNegative() {
		
		when(cookbookDao.getCookbookById(1)).thenReturn(null);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			cookbookServiceSut.getCookbook(1);
			
		});
	
		
	}
	
	@Test
	public void addRecipeToCookbookPositive() {
		
		Cookbook cookbook = new Cookbook();
		cookbook.setName("test");
		
		Cookbook expectedCookbook = new Cookbook();
		expectedCookbook.setName("test");
		expectedCookbook.setRecipeIds(" 5");
		
		when(cookbookDao.getCookbookById(1)).thenReturn(cookbook);
		
		
		Assertions.assertEquals(cookbook, cookbookServiceSut.addRecipeToCookbook(1, 1));
		
		
	}
	
	
	@Test
	public void addRecipeToCookbookCookbookDoesntExistNegative() {
		
		when(cookbookDao.getCookbookById(1)).thenReturn(null);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			cookbookServiceSut.addRecipeToCookbook(1, 1);
			
		});
		
		
		
	}
	
	@Test
	public void createCookbookPositive() throws Exception {
		
		Cookbook cookbook = new Cookbook();
		cookbook.setName("test");
		
		User user = new User();
		user.setId(1);
		
		cookbook.setUser(user);
		
		when(userDao.getUserById(1)).thenReturn(user);
		when(cookbookDao.createNewCookbook(cookbook)).thenReturn(cookbook);
		
		Assertions.assertEquals(cookbook, cookbookServiceSut.createNewCookbook(cookbook, 1));
		
	}
	
	@Test
	public void createCookbookNameTooLongNegative() {
		
		Cookbook cookbook = new Cookbook();
		cookbook.setName(longString);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			cookbookServiceSut.createNewCookbook(cookbook, 1);
			
		});
		
	}
	
	@Test
	public void createCookbookUserDoesntExist() {
		
		Cookbook cookbook = new Cookbook();
		
		when(userDao.getUserById(1)).thenReturn(null);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			cookbookServiceSut.createNewCookbook(cookbook, 1);
			
		});
		
	}
}
