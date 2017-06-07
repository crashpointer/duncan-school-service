package org.duncan.dao;

import java.util.List;

import org.duncan.entity.Brand;

/**
 * @author crash pointer
 * <p>
 * This interface defines all required methods for brand user interface.
 * </p>
 */
public interface IBrandDAO {
	
	/**
	 * <p>This method is used to search in all records.</p>
	 * @param name
	 * @return List
	 */
	List<Brand> findBrand(String name);
	
	/**
	 * <p>This method fetch all records.</p>
	 * @return List
	 */
	List<Brand> getAllBrands();
	
	/**
	 * <p>This method fetch single record by id field from database.</p>
	 * @param id
	 * @return Brand
	 */
	Brand getBrandById(int id);
    
	/**
	 * <p>This method is used to add a new record.</p>
	 * @param brand
	 */
	void saveBrand(Brand brand);
    
	/**
	 * <p>This method is used to edit a record.</p>
	 * @param brand
	 */
	void updateBrand(Brand brand);
    
	/**
	 * <p>This method is used to remove a record.</p>
	 * @param id
	 */
	void deleteBrand(int id);
    
    /**
     * <p>This method is used to check brand.</p>
     * @param name
     * @return Strings
     */
    boolean brandExists(String name);

}
