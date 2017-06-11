package org.duncan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.duncan.dao.IVehicleDAO;
import org.duncan.entity.Vehicle;

/**
 * @author crash pointer
 * <p>Provides bridge between controller and database access layer.</p>
 */
@Service
public class VehicleService implements IVehicleService {

	@Autowired
	private IVehicleDAO vehicleDAO;

	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleDAO.getAllVehicles();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		Vehicle vehicle = vehicleDAO.getVehicleById(id);
		return vehicle;
	}

	@Override
	public synchronized boolean saveVehicle(Vehicle vehicle) {
        if (vehicleDAO.vehicleExists(vehicle.getNickname(), vehicle.getPlate())) {
            return false;
        } else {
            vehicleDAO.saveVehicle(vehicle);
            return true;
        }
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		vehicleDAO.updateVehicle(vehicle);		
	}

	@Override
	public void deleteVehicle(int id) {
		vehicleDAO.deleteVehicle(id);
	}

	@Override
	public List<Vehicle> findVehicle(String nickname, String plate, int modelId, byte typeId) {
		return vehicleDAO.findVehicle(nickname, plate, modelId, typeId);
	}

	@Override
	public boolean vehicleExists(String nickname, String plate) {
		return vehicleDAO.vehicleExists(nickname, plate);
	}

}
