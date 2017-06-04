package org.duncan.dao;

import java.util.List;

import org.duncan.entity.Model;

public interface IModelDAO {
	public List<Model> getAllModels();
	public Model getModelById(int id);
	public List<Model> getModelListByBrandId(int brandId);	
	public List<Model> findModelByName(String name);
	public List<Model> findModelByNameWithBrandId(String name, int brandId);
	public void addModel(Model model);
	public void updateModel(Model model);
	public void deleteModel(int id);
}
