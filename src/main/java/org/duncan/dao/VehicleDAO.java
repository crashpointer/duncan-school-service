package org.duncan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.duncan.entity.Vehicle;

/**
 * @author crash pointer
 * <p>Implements all methods of interface vehicle database access.</p>
 */
@Transactional
@Repository
public class VehicleDAO implements IVehicleDAO {

	@PersistenceContext	
	private EntityManager entityManager;	

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getAllVehicles() {
		String hql = "FROM Vehicle as v JOIN FETCH v.model ORDER BY v.id desc";
		return (List<Vehicle>) entityManager.createQuery(hql)
				.setMaxResults(30)
				.getResultList();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		return entityManager.find(Vehicle.class, id);
	}

	@Override
	public void saveVehicle(Vehicle vehicle) {
		entityManager.persist(vehicle);
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		Vehicle v = getVehicleById(vehicle.getId());
		v.setNickname(vehicle.getNickname());
		v.setPlate(vehicle.getPlate());
		v.setModel(vehicle.getModel());
		v.setYear(vehicle.getYear());
		v.setColor(vehicle.getColor());
		v.setActive(vehicle.getActive());
		entityManager.flush();
	}

	@Override
	public void deleteVehicle(int id) {
		entityManager.remove(getVehicleById(id));
	}

	@Override
	public boolean vehicleExists(String nickname, String plate) {
		String hql = "FROM Vehicle as v WHERE lower(v.nickname) = lower(?) or lower(v.plate) = lower(?)";
		int count = entityManager.createQuery(hql)
				.setParameter(1, nickname)
				.setParameter(2, plate)
				.getResultList().size();

		return count != 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findVehicle(String nickname, String plate, int modelId, byte typeId) {
		String hql = "FROM Vehicle as v JOIN FETCH v.model WHERE lower(v.nickname) like lower(?) and lower(v.plate) like lower(?) %s ORDER BY v.id desc";
		if(modelId > 0){
			hql = String.format(hql, "and v.model.id = ? %s");
		} else{
			hql = String.format(hql, "and (v.model.id = ? or 1=1) %s");
		}
		
		if(typeId > 0){
			hql = String.format(hql, "and v.typeOfVehicle = ?");
		} else{
			hql = String.format(hql, "and (v.typeOfVehicle = ? or 1 = 1)");
		}
		
		return (List<Vehicle>) entityManager.createQuery(hql)
				.setParameter(1, "%" + nickname + "%")
				.setParameter(2, "%" + plate + "%")
				.setParameter(3, modelId)
				.setParameter(4, typeId)
				.setMaxResults(30)
				.getResultList();
	}

}
