package org.duncan.service;

import java.util.List;

import org.duncan.entity.Brand;

public interface IBrandService {
	public List<Brand> findBrand(String name);
	public List<Brand> getAllBrands();
	public Brand getBrandById(int id);
	public boolean saveBrand(Brand brand);
	public void updateBrand(Brand brand);
	public void deleteBrand(int id);
}
