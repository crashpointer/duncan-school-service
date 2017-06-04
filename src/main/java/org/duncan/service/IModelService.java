package org.duncan.service;

import java.util.List;

import org.duncan.entity.Model;

public interface IModelService {
	public List<Model> getAllModels();
	public Model getModelById(int id);
	public List<Model> getModelListByBrandId(int brandId);	
	public List<Model> findModelByName(String name);
	public List<Model> findModelByNameWithBrandId(String name, int brandId);
	public void saveModel(Model model);
	public void updateModel(Model model);
	public void deleteModel(int id);
}
