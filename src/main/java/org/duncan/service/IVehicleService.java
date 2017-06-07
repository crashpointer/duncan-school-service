package org.duncan.service;

import java.util.List;

import org.duncan.entity.Vehicle;

public interface IVehicleService {    
	public List<Vehicle> getAllVehicles();
	public List<Vehicle> findVehicleByNicknameWithPlate(String nickname, String plate);
    public List<Vehicle> findVehicleByNickname(String nickname);
    public List<Vehicle> findVehicleByModelId(String nickname, String plate, int modelId);
    public List<Vehicle> findVehicleByTypeOfVehicle(String nickname, String plate, byte typeId);
    public List<Vehicle> findVehicle(String nickname, String plate, int modelId, byte typeId);
    public Vehicle getVehicleById(int id);
    public boolean saveVehicle(Vehicle vehicle);
    public void updateVehicle(Vehicle vehicle);
    public void deleteVehicle(int id);
}
