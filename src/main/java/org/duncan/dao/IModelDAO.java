package org.duncan.dao;

import java.util.List;

import org.duncan.entity.Model;

/**
 * @author crash pointer
 * <p>This class provides database access for the models.</p>
 * <p>All methods must be implemented by extended subclasses.</p>
 */
public interface IModelDAO {
	
	/**
	 * <p>Fetch all the models.</p>
	 * @return List
	 */
	public List<Model> getAllModels();
	
	/**
	 * <p>Fetch a model by a id.</p>
	 * @param id
	 * @return Model
	 */
	public Model getModelById(int id);
	
	/**
	 * <p>Fetch model list by a brand.</p>
	 * @param brandId
	 * @return List
	 */
	public List<Model> getModelListByBrandId(int brandId);	
	
	/**
	 * <p>This method is used to search in all records.</p>
	 * @param name
	 * @param brandId
	 * @return List
	 */
	public List<Model> findModel(String name, int brandId);
	
	/**
	 * <p>This method is used to add a new record.</p>
	 * @param model
	 */
	public void saveModel(Model model);
	
	/**
	 * <p>This method is used to edit a record.</p>
	 * @param model
	 */
	public void updateModel(Model model);
	
	/**
	 * <p>This method is used to remove a record.</p>
	 * @param id
	 */
	public void deleteModel(int id);
	
}
