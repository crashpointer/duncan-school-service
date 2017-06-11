package org.duncan.controller;

import org.duncan.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTests {

	@Autowired
    private MockMvc mvc;
	
    @MockBean
    private UserService userService;

	@Test
	public void testLogin() throws Exception{
		mvc.perform(get("/login").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isUnauthorized())
				.equals(null);
	}
	
	@Test
	public void testRegistration() throws Exception{
		mvc.perform(get("/registration").accept(MediaType.TEXT_PLAIN))
			.andExpect(status().isUnauthorized())
			.equals(null);		
	}
	
}
