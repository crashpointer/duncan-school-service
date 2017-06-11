package org.duncan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.duncan.entity.Model;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author crash pointer
 * <p>Implements all methods of interface model database access.</p>
 */
@Transactional
@Repository
public class ModelDAO implements IModelDAO {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Model> getAllModels() {
		String hql = "SELECT m FROM Model as m JOIN FETCH m.brand ORDER BY m.id desc";
		return (List<Model>) entityManager.createQuery(hql)
				.setMaxResults(30)
				.getResultList();
	}

	@Override
	public Model getModelById(int id) {
		return entityManager.find(Model.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Model> getModelListByBrandId(int brandId) {
		String hql = "FROM Model as m JOIN FETCH m.brand WHERE m.brand.id = ? ORDER BY m.id desc";
		return (List<Model>) entityManager.createQuery(hql)
				.setParameter(1, brandId)
				.setMaxResults(30)
				.getResultList();
	}

	@Override
	public void saveModel(Model model) {
		entityManager.persist(model);
	}

	@Override
	public void updateModel(Model model) {
		Model m = getModelById(model.getId());
		m.setName(model.getName());
		m.setBrand(model.getBrand());
		entityManager.flush();
	}

	@Override
	public void deleteModel(int id) {
		entityManager.remove(getModelById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Model> findModel(String name, int brandId) {
		String hql = "FROM Model as m JOIN FETCH m.brand WHERE lower(m.name) like lower(?) %s ORDER BY m.id desc";
		if(brandId > 0){
			hql = String.format(hql, "and m.brand.id = ?");
		} else{
			hql = String.format(hql, "and (m.brand.id = ? or 1=1)");
		}
		
		return (List<Model>) entityManager.createQuery(hql)
				.setParameter(1, "%" + name + "%")
				.setParameter(2, brandId)
				.setMaxResults(30)
				.getResultList();
	}

}
