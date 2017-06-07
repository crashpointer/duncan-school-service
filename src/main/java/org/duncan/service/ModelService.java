package org.duncan.service;

import java.util.List;

import org.duncan.dao.IModelDAO;
import org.duncan.entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ceren
 *
 */
@Service
public class ModelService implements IModelService {
	
	@Autowired
	private IModelDAO modelDAO;

	@Override
	public List<Model> getAllModels() {
		return modelDAO.getAllModels();
	}

	@Override
	public Model getModelById(int id) {
		return modelDAO.getModelById(id);
	}

	@Override
	public List<Model> getModelListByBrandId(int brandId) {
		return modelDAO.getModelListByBrandId(brandId);
	}

	@Override
	public List<Model> findModelByName(String name) {
		return modelDAO.findModelByName(name);
	}

	@Override
	public List<Model> findModel(String name, int brandId) {
		return modelDAO.findModel(name, brandId);
	}

	@Override
	public void saveModel(Model model) {
		modelDAO.saveModel(model);
	}

	@Override
	public void updateModel(Model model) {
		modelDAO.updateModel(model);
	}

	@Override
	public void deleteModel(int id) {
		modelDAO.deleteModel(id);
	}

}
