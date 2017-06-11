package org.duncan.service;

import static org.junit.Assert.*;

import java.time.Year;
import java.util.List;

import org.duncan.Application;
import org.duncan.entity.Brand;
import org.duncan.entity.Model;
import org.duncan.entity.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = Application.class) 
@DataJpaTest
public class VehicleServiceTests {
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private VehicleService vehicleService;
	
	private Brand brand;
	
	private Model model;
	
	private Vehicle vehicle;
	
	private static String brandName = "TestBrand";
	
	private static String modelName = "TestModel";
	
	private static String vehicleNickname = "TestVehicle";
	
	private static String vehiclePlate = "35BC123";
	
	private static int vehicleModelYear = Year.now().getValue();
	
	private static String vehicleColor = "#000000";
	
	private static byte vehicleType = 1;
	
	private static String updateVehicleNickname = "TestUpdateVehicle";
	
	@Before
	public void setUp(){
		brand = new Brand();
		brand.setName(brandName);
		brandService.saveBrand(brand);
		
		model = new Model();
		model.setBrand(brand);
		model.setName(modelName);
		modelService.saveModel(model);
		
		vehicle = new Vehicle();
		vehicle.setModel(model);
		vehicle.setNickname(vehicleNickname);
		vehicle.setPlate(vehiclePlate);
		vehicle.setYear(vehicleModelYear);
		vehicle.setColor(vehicleColor);
		vehicle.setTypeOfVehicle(vehicleType);
		vehicleService.saveVehicle(vehicle);
	}
	
	@Test
	public void testGetAllVehicles(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);
		assertTrue(vehicle.getId() > 0);

		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		assertTrue(vehicles.size() > 0);
	}
	
	@Test
	public void testGetVehicleById(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);
		assertTrue(vehicle.getId() > 0);
		
		Vehicle v = vehicleService.getVehicleById(vehicle.getId());
		assertEquals(vehicleNickname, v.getNickname());
	}
	
	@Test
	public void testFindVehicle(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);
		assertTrue(vehicle.getId() > 0);
		
		List<Vehicle> vehicles = vehicleService.findVehicle(vehicle.getNickname(), vehicle.getPlate(), vehicle.getModel().getId(), vehicle.getTypeOfVehicle());
		assertTrue(vehicles.size() > 0);
	}
	
	@Test
	public void testSaveVehicle(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);
		assertTrue(vehicle.getId() > 0);		
	}
	
	@Test
	public void testUpdateVehicle(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);
		assertTrue(vehicle.getId() > 0);		
		
		vehicle.setNickname(updateVehicleNickname);
		List<Vehicle> vehicles = vehicleService.findVehicle(updateVehicleNickname, vehicle.getPlate(), vehicle.getModel().getId(), vehicle.getTypeOfVehicle());
		assertTrue(vehicles.size() > 0);
	}
	
	@Test
	public void testDeleteVehicle(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);
		assertTrue(vehicle.getId() > 0);		

		vehicleService.deleteVehicle(vehicle.getId());
		Vehicle v = vehicleService.getVehicleById(vehicle.getId());
		assertEquals(null, v);
	}
	
}
