package org.duncan.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.duncan.service.ModelService;
import org.duncan.service.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTests {

	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private ModelService modelService;
	
	@MockBean
	private VehicleService vehicleService;
	
	@Test
	public void testVehicleHome() throws Exception{
    	mvc.perform(get("/vehicle").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);
	}
	
	@Test
	public void testNewVehicle() throws Exception{
    	mvc.perform(get("/vehicle/new").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);		
	}
	
	@Test
	public void testUpdateVehicle() throws Exception{
    	mvc.perform(get("/vehicle/update/1").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);
	}
	
	@Test
	public void testDeleteVehicle() throws Exception{
    	mvc.perform(get("/vehicle/remove/1").accept(MediaType.TEXT_PLAIN))
    	.andExpect(status().isUnauthorized())
    	.equals(null);		
	}

}
