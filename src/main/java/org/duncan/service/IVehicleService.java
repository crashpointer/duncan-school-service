package org.duncan.service;

import java.util.List;

import org.duncan.entity.Vehicle;

/**
 * @author crash pointer
 * <p>Provides bridge between controller and database access layer.</p>
 */
public interface IVehicleService {    
	
	/**
	 * @return List
	 */
	public List<Vehicle> getAllVehicles();
    
	/**
	 * @param nickname
	 * @param plate
	 * @param modelId
	 * @param typeId
	 * @return List
	 */
	public List<Vehicle> findVehicle(String nickname, String plate, int modelId, byte typeId);
    
	/**
	 * @param id
	 * @return Vehicle
	 */
	public Vehicle getVehicleById(int id);
	
	/**
	 * @param nickname
	 * @param plate
	 * @return boolean
	 */
	public boolean vehicleExists(String nickname, String plate);
    
	/**
	 * @param vehicle
	 * @return boolean
	 */
	public boolean saveVehicle(Vehicle vehicle);
    
	/**
	 * @param vehicle
	 */
	public void updateVehicle(Vehicle vehicle);
    
	/**
	 * @param id
	 */
	public void deleteVehicle(int id);
	
}
