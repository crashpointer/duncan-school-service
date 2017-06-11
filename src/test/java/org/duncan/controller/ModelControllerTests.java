package org.duncan.controller;

import org.duncan.service.BrandService;
import org.duncan.service.ModelService;
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
@WebMvcTest(ModelController.class)
public class ModelControllerTests {

	@Autowired
    private MockMvc mvc;

	@MockBean
	private BrandService brandService;
	
	@MockBean
	private ModelService modelService;
	
	@Test
	public void testModelHome() throws Exception{
    	mvc.perform(get("/model").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);    			
	}
	
	@Test
	public void testNewModel() throws Exception{
    	mvc.perform(get("/model/new").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);
	}
	
	@Test
	public void testUpdateModeModel() throws Exception{		
    	mvc.perform(get("/model/update/1").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);
	}
	
	@Test
	public void testDeleteModel() throws Exception{
    	mvc.perform(get("/model/remove/1").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);		
	}

}
