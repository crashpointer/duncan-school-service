package org.duncan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.duncan.entity.Brand;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BrandDAO implements IBrandDAO{

	@PersistenceContext	
	private EntityManager entityManager;	

	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> getAllBrands() {
		String hql = "FROM Brand as b ORDER BY b.id desc";
		return (List<Brand>) entityManager.createQuery(hql).setMaxResults(30).getResultList();
	}

	@Override
	public Brand getBrandById(int id) {
		return entityManager.find(Brand.class, id);
	}

	@Override
	public void addBrand(Brand brand) {
		entityManager.persist(brand);
	}

	@Override
	public void updateBrand(Brand brand) {
		Brand b = getBrandById(brand.getId());
		b.setName(brand.getName());
		entityManager.flush();
	}

	@Override
	public void deleteBrand(int id) {
		entityManager.remove(getBrandById(id));
	}

	@Override
	public boolean brandExists(String name) {
		String hql = "FROM Brand as b WHERE b.name = ?";
		int count = entityManager.createQuery(hql)
				.setParameter(1, name)
				.getResultList().size();

		return count > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> findBrandByName(String name) {
		String hql = "FROM Brand as b WHERE lower(b.name) like lower(?) ORDER BY b.name asc";
		return (List<Brand>) entityManager.createQuery(hql)
				.setParameter(1, "%" + name + "%")
				.setMaxResults(30)
				.getResultList();
	}

}
