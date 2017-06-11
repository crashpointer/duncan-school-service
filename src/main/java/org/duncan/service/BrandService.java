package org.duncan.service;

import java.util.List;

import org.duncan.dao.IBrandDAO;
import org.duncan.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author crash pointer
 * <p>Provides bridge between controller and database access layer.</p>
 */
@Service
public class BrandService implements IBrandService {
	
	@Autowired
	private IBrandDAO brandDAO;

	@Override
	public List<Brand> findBrand(String name) {
		return brandDAO.findBrand(name);
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
		
		brandDAO.saveBrand(brand);
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
