package org.duncan.service;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.duncan.Application;
import org.duncan.entity.Brand;
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
public class BrandServiceTests {
	
	@Autowired
	private BrandService brandService;
	
	private Brand brand;
	
	private static String brandName = "TestBrand";
	
	private static String updateBrandName = "TestUpdateBrand";
	
	@Before
	public void setUp(){
		brand = new Brand();
		brand.setName(brandName);
		brandService.saveBrand(brand);		
	}
	
	@Test
	public void testGetAllBrands(){
		assertTrue(brand.getId() > 0);
		
		assertTrue(brandService.getAllBrands().size() > 0);
	}
	
	@Test
	public void testFindBrand(){
		assertTrue(brand.getId() > 0);

		List<Brand> brands = brandService.findBrand(brandName);
		assertTrue(brands.size() == 1);
		
		for(Iterator<Brand> iterator = brands.iterator(); iterator.hasNext();){
			Brand b = iterator.next();
			assertEquals(brandName, b.getName());
		}
	}
	
	@Test
	public void testSaveBrand(){
		assertTrue(brand.getId() > 0);

		List<Brand> brands = brandService.findBrand(brandName);
		assertTrue(brands.size() == 1);
	}
	
	@Test
	public void testUpdateBrand(){
		assertTrue(brand.getId() > 0);
		
		brand.setName(updateBrandName);
		brandService.updateBrand(brand);
		
		Brand b = brandService.getBrandById(brand.getId());
		assertEquals(updateBrandName, b.getName());
	}
	
	@Test
	public void testDeleteBrand(){
		assertTrue(brand.getId() > 0);
		
		brandService.deleteBrand(brand.getId());
		
		Brand b = brandService.getBrandById(brand.getId());
		assertEquals(null, b);
	}
	
}
