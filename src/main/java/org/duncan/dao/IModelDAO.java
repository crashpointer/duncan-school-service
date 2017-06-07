package org.duncan.dao;

import java.util.List;

import org.duncan.entity.Model;

/**
 * @author ceren
 *
 */
public interface IModelDAO {
	
	/**
	 * @return List<Model>
	 */
	public List<Model> getAllModels();
	
	/**
	 * @param int id
	 * @return Model
	 */
	public Model getModelById(int id);
	
	/**
	 * @param int brandId
	 * @return List<Model>
	 */
	public List<Model> getModelListByBrandId(int brandId);	
	
	/**
	 * @param name
	 * @return List<Model>
	 */
	public List<Model> findModelByName(String name);
	
	/**
	 * @param name
	 * @param brandId
	 * @return List<Model>
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
