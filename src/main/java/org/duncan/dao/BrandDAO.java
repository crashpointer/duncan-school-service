package org.duncan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.duncan.entity.Brand;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author crash pointer
 * <p>Implements all methods of interface brand database access.</p> 
 */
@Transactional
@Repository
public class BrandDAO implements IBrandDAO{

	@PersistenceContext	
	private EntityManager entityManager;	

	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> getAllBrands() {
		String hql = "FROM Brand as b ORDER BY b.id desc";
		return (List<Brand>) entityManager.createQuery(hql)
				.setMaxResults(30)
				.getResultList();
	}

	@Override
	public Brand getBrandById(int id) {
		return entityManager.find(Brand.class, id);
	}

	@Override
	public void saveBrand(Brand brand) {
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
		String hql = "FROM Brand as b WHERE lower(b.name) = lower(?)";
		int count = entityManager.createQuery(hql)
				.setParameter(1, name)
				.getResultList().size();

		return count != 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> findBrand(String name) {
		String hql = "FROM Brand as b WHERE lower(b.name) like lower(?) ORDER BY b.id desc";
		return (List<Brand>) entityManager.createQuery(hql)
				.setParameter(1, "%" + name + "%")
				.setMaxResults(30)
				.getResultList();
	}

}
