package org.duncan.dao;

import java.util.List;

import org.duncan.entity.Vehicle;

/**
 * @author crash pointer
 * <p>This class provides database access for the vehicles.</p>
 * <p>All methods must be implemented by extended subclasses.</p>
 */
public interface IVehicleDAO {
	
	/**
	 * <p>Fetch all the vehicles.</p>
	 * @return List
	 */
	public List<Vehicle> getAllVehicles();
    
	/**
	 * <p>Fetch a vehicle by the id.</p>
	 * @param id
	 * @return Vehicle
	 */
	public Vehicle getVehicleById(int id);
	
    /**
     * <p>Search into all vehicles.</p>
     * @param nickname
     * @param plate
     * @param modelId
     * @param typeId
     * @return List
     */
    public List<Vehicle> findVehicle(String nickname, String plate, int modelId, byte typeId);
    
    /**
     * <p>Add a new vehicle.</p>
     * @param vehicle
     */
    public void saveVehicle(Vehicle vehicle);
    
    /**
     * <p>Edit a vehicle.</p>
     * @param vehicle
     */
    public void updateVehicle(Vehicle vehicle);
    
    /**
     * <p>Remove a vehicle.</p>
     * @param id
     */
    public void deleteVehicle(int id);
    
    /**
     * <p>Check vehicle exists by nickname or plate.</p>
     * @param nickname
     * @param plate
     * @return boolean
     */
    public boolean vehicleExists(String nickname, String plate);
    
}
