package edu.tcu.mi.spring.web.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.tcu.mi.spring.web.entity.User;
import edu.tcu.mi.spring.web.security.Authority;
import edu.tcu.mi.spring.web.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:testContext.xml"})
@ActiveProfiles("jpa")
@WebAppConfiguration
public class UserServiceTest {
    @Autowired
    private UserService service;
	
    @Test
	public void test() {
		List<User> users = service.findAll();
		for(User user : users){
			System.out.println(user);
		}
	}

//	@Test
	public void create(){
		User entity = new User("test@gmail.com", "test", Authority.ROLE_USER) ;
		service.save(entity);
	}
	

}
