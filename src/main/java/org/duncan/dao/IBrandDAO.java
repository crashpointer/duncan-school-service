package org.duncan.dao;

import java.util.List;

import org.duncan.entity.Brand;

public interface IBrandDAO {
	
	List<Brand> findBrandByName(String name);
	List<Brand> getAllBrands();
	Brand getBrandById(int id);
    void addBrand(Brand brand);
    void updateBrand(Brand brand);
    void deleteBrand(int id);
    boolean brandExists(String name);

}
