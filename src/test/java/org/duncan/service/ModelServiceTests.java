package org.duncan.service;

import static org.junit.Assert.*;

import java.util.List;

import org.duncan.Application;
import org.duncan.entity.Brand;
import org.duncan.entity.Model;
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
public class ModelServiceTests {

	@Autowired
	private BrandService brandService;
	
	@Autowired
	private ModelService modelService;
	
	private Brand brand;
	
	private Model model;
	
	private static String brandName = "TestBrand";
	
	private static String modelName = "TestModel";
	
	private static String updateModelName = "TestUpdateModel";
	
	@Before
	public void setUp(){
		brand = new Brand();
		brand.setName(brandName);
		brandService.saveBrand(brand);
		
		model = new Model();
		model.setBrand(brand);
		model.setName(modelName);
		modelService.saveModel(model);
	}
	
	@Test
	public void testGetAllModels(){		
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);

		List<Model> models = modelService.getAllModels();
		assertTrue(models.size() > 0);
	}
	
	@Test
	public void testGetModelById(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);

		Model m = modelService.getModelById(model.getId());
		assertEquals(modelName, m.getName());
	}
	
	@Test
	public void testGetModelListByBrandId(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);
		
		List<Model> models = modelService.getModelListByBrandId(model.getBrand().getId());
		assertTrue(models.size() > 0);		
	}
	
	@Test
	public void testFindModel(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);

		List<Model> models = modelService.findModel(modelName, model.getBrand().getId());
		assertTrue(models.size() > 0);
	}
	
	@Test
	public void testSaveModel(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);
	}
	
	@Test
	public void testUpdateModel(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);
		
		model.setName(updateModelName);
		modelService.updateModel(model);
		List<Model> models = modelService.findModel(updateModelName, model.getBrand().getId());
		assertTrue(models.size() > 0);
	}
	
	@Test
	public void testDeleteModel(){
		assertTrue(brand.getId() > 0);
		assertTrue(model.getId() > 0);
		
		modelService.deleteModel(model.getId());
		Model m = modelService.getModelById(model.getId());
		assertEquals(null, m);
	}
	
}
