package org.duncan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.duncan.entity.Model;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ModelDAO implements IModelDAO {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Model> getAllModels() {
		String hql = "FROM Model as m ORDER BY m.id desc";
		return (List<Model>) entityManager.createQuery(hql).setMaxResults(30).getResultList();
	}

	@Override
	public Model getModelById(int id) {
		return entityManager.find(Model.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Model> getModelListByBrandId(int brandId) {
		String hql = "FROM Model as m WHERE m.brandId = ? ORDER BY m.id desc";
		return (List<Model>) entityManager.createQuery(hql)
				.setParameter(1, brandId)
				.setMaxResults(30)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Model> findModelByName(String name) {
		String hql = "FROM Model as m WHERE lower(m.name) like lower(?) ORDER BY m.name asc";
		return (List<Model>) entityManager.createQuery(hql)
				.setParameter(1, "%" + name + "%")
				.setMaxResults(30)
				.getResultList();
	}

	@Override
	public void addModel(Model model) {
		entityManager.persist(model);
	}

	@Override
	public void updateModel(Model model) {
		Model m = getModelById(model.getId());
		m.setName(model.getName());
		m.setBrandId(model.getBrandId());
		entityManager.flush();
	}

	@Override
	public void deleteModel(int id) {
		entityManager.remove(getModelById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Model> findModelByNameWithBrandId(String name, int brandId) {
		String hql = "FROM Model as m WHERE m.brandId = ? and lower(m.name) like lower(?)";
		return (List<Model>) entityManager.createQuery(hql)
				.setParameter(1, brandId)
				.setParameter(2, "%" + name + "%")
				.setMaxResults(30)
				.getResultList();
	}

}
