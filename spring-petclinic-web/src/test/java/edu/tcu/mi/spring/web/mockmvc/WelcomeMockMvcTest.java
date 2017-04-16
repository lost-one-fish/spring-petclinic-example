package edu.tcu.mi.spring.web.mockmvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-context.xml"})
@ActiveProfiles("jpa")
@WebAppConfiguration
public class WelcomeMockMvcTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
	
	@Before
	public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void test() {
		try {
			ResultActions results = mockMvc
					.perform(MockMvcRequestBuilders.get("/api/User").accept(MediaType.APPLICATION_JSON))
//	                .andExpect(MockMvcResultMatchers.status().isOk())
	                ;
			MvcResult result = results.andReturn();
			MockHttpServletResponse response = result.getResponse();
			System.out.println("response : " + "\t" + response.getContentAsString());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}
