package org.duncan.dao;

import java.util.List;

import org.duncan.entity.Vehicle;

public interface IVehicleDAO {
	List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(int id);
    List<Vehicle> findVehicleByNicknameWithPlate(String nickname, String plate);
    List<Vehicle> findVehicleByNickname(String nickname);
    List<Vehicle> findVehicleByModelId(String nickname, String plate, int modelId);
    List<Vehicle> findVehicleByTypeOfVehicle(String nickname, String plate, byte typeId);
    List<Vehicle> findVehicle(String nickname, String plate, int modelId, byte typeId);
    void addVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    void deleteVehicle(int id);
    boolean vehicleExists(String nickname, String plate);
}
