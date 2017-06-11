package org.duncan.service;

import java.util.List;

import org.duncan.entity.Model;

/**
 * @author crash pointer
 * <p>Provides bridge between controller and database access layer.</p>
 */
public interface IModelService {
	
	/**
	 * @return List
	 */
	public List<Model> getAllModels();
	
	/**
	 * @param id
	 * @return Model
	 */
	public Model getModelById(int id);
	
	/**
	 * @param brandId
	 * @return List
	 */
	public List<Model> getModelListByBrandId(int brandId);
	
	/**
	 * @param name
	 * @param brandId
	 * @return List
	 */
	public List<Model> findModel(String name, int brandId);
	
	/**
	 * @param model
	 */
	public void saveModel(Model model);
	
	/**
	 * @param model
	 */
	public void updateModel(Model model);
	
	/**
	 * @param id
	 */
	public void deleteModel(int id);
	
}
