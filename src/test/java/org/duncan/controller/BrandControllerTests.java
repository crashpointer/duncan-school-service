package org.duncan.controller;

import org.duncan.service.BrandService;
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
@WebMvcTest(BrandController.class)
public class BrandControllerTests {

	@Autowired
    private MockMvc mvc;

    @MockBean
    private BrandService brandService;
    
    @Test
    public void testBrandHome() throws Exception{
    	mvc.perform(get("/brand").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);    	
    }
    
    @Test
    public void testNewBrand() throws Exception{
    	mvc.perform(get("/brand/new").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);
    }
    
    @Test
    public void updateModeBrand() throws Exception{    	
    	mvc.perform(get("/brand/update/1").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);
    }
    
    @Test
    public void deleteBrand() throws Exception{
    	mvc.perform(get("/brand/remove/1").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);
    }

}
