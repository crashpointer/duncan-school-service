package org.duncan.dao;

import java.util.List;

import org.duncan.entity.Vehicle;

/**
 * @author crash pointer
 * <p>
 * Vehicle database access object
 * </p>
 */
public interface IVehicleDAO {
	
	/**
	 * <p>Fetch all vehicle lists</p>
	 * @return List
	 */
	public List<Vehicle> getAllVehicles();
    
	/**
	 * <p>Fetch vehicle by id field</p>
	 * @param id
	 * @return Vehicle
	 */
	public Vehicle getVehicleById(int id);
	
    public List<Vehicle> findVehicleByNicknameWithPlate(String nickname, String plate);
    public List<Vehicle> findVehicleByNickname(String nickname);
    public List<Vehicle> findVehicleByModelId(String nickname, String plate, int modelId);
    public List<Vehicle> findVehicleByTypeOfVehicle(String nickname, String plate, byte typeId);
    public List<Vehicle> findVehicle(String nickname, String plate, int modelId, byte typeId);
    public void saveVehicle(Vehicle vehicle);
    public void updateVehicle(Vehicle vehicle);
    public void deleteVehicle(int id);
    public boolean vehicleExists(String nickname, String plate);
}
