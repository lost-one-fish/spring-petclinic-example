package edu.tcu.mi.spring.web.mockmvc;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import edu.tcu.mi.spring.web.entity.User;
import edu.tcu.mi.spring.web.security.entity.PetclinicUserDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-Context.xml"})
@ActiveProfiles("mongodb")
@WebAppConfiguration
public class GenericMockMvcTest {

	protected static Logger logger = Logger.getLogger(GenericMockMvcTest.class);
	
    @InjectMocks
    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;
    protected TestingAuthenticationToken principal;
    

	protected Gson gson = new Gson();
	
	@Before
	public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        
        UserDetails user = new PetclinicUserDetails(new User("petclinic", "petclinic", "ROLE_ADMIN"));
        principal = new TestingAuthenticationToken(user, null);
        SecurityContextHolder.getContext().setAuthentication(principal);
	}
}
