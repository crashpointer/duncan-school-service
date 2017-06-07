package org.duncan.dao;

import java.util.List;

import org.duncan.entity.Model;

/**
 * @author crash pointer
 * <p>
 * This interface defines all required methods for model user interface.
 * All methods must be implement.
 * </p>
 */
public interface IModelDAO {
	
	/**
	 * <p>This method fetch all records from models table.</p>
	 * @return List
	 */
	public List<Model> getAllModels();
	
	/**
	 * <p>
	 * This method fetch single record from models table.
	 * Id field pass as parameter. It is a unique field. 
	 * </p>
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
	 * <p>This method is used to search by string in all records.</p>
	 * @param name
	 * @return List<Model>
	 */
	public List<Model> findModelByName(String name);
	
	/**
	 * <p>This method is used to search in all records.</p>
	 * @param name
	 * @param brandId
	 * @return List<Model>
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
