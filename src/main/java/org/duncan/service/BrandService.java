package org.duncan.service;

import java.util.List;

import org.duncan.dao.IBrandDAO;
import org.duncan.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements IBrandService {
	
	@Autowired
	private IBrandDAO brandDAO;

	@Override
	public List<Brand> findBrandByName(String name) {
		return brandDAO.findBrandByName(name);
	}

	@Override
	public List<Brand> getAllBrands() {
		return brandDAO.getAllBrands();
	}

	@Override
	public Brand getBrandById(int id) {
		return brandDAO.getBrandById(id);
	}

	@Override
	public synchronized boolean saveBrand(Brand brand) {
		if(brandDAO.brandExists(brand.getName()))
			return false;
		
		brandDAO.addBrand(brand);
		return true;
	}
	
	@Override
	public void updateBrand(Brand brand){
		brandDAO.updateBrand(brand);
	}
	
	@Override
	public void deleteBrand(int id){
		brandDAO.deleteBrand(id);
	}
	
}
