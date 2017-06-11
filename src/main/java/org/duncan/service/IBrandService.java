package org.duncan.service;

import java.util.List;

import org.duncan.entity.Brand;

/**
 * @author crash pointer
 * <p>Provides bridge between controller and database access layer.</p>
 */
public interface IBrandService {
	
	/**
	 * @param name
	 * @return List
	 */
	public List<Brand> findBrand(String name);
	
	/**
	 * @return List
	 */
	public List<Brand> getAllBrands();
	
	/**
	 * @param id
	 * @return Brand
	 */
	public Brand getBrandById(int id);
	
	/**
	 * @param brand
	 * @return boolean
	 */
	public boolean saveBrand(Brand brand);
	
	/**
	 * @param brand
	 */
	public void updateBrand(Brand brand);
	
	/**
	 * @param id
	 */
	public void deleteBrand(int id);
	
}
