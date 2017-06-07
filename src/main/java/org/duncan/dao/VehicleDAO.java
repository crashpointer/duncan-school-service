package org.duncan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.duncan.entity.Vehicle;

@Transactional
@Repository
public class VehicleDAO implements IVehicleDAO {

	@PersistenceContext	
	private EntityManager entityManager;	

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getAllVehicles() {
		String hql = "FROM Vehicle as v ORDER BY v.id desc";
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
		entityManager.flush();
	}

	@Override
	public void deleteVehicle(int id) {
		entityManager.remove(getVehicleById(id));
	}

	@Override
	public boolean vehicleExists(String nickname, String plate) {
		String hql = "FROM Vehicle as v WHERE v.nickname = ? or v.plate = ?";
		int count = entityManager.createQuery(hql).setParameter(1, nickname)
		              .setParameter(2, plate).getResultList().size();
		
		return count > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findVehicleByNicknameWithPlate(String nickname, String plate) {
		String hql = "FROM Vehicle as v WHERE lower(v.nickname) like lower(?) and lower(v.plate) like lower(?)";
		return (List<Vehicle>) entityManager.createQuery(hql)
				.setParameter(1, "%" + nickname + "%")
				.setParameter(2, "%" + plate + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findVehicleByNickname(String nickname) {
		String hql = "FROM Vehicle as v WHERE lower(v.nickname) like lower(?)";
		return (List<Vehicle>) entityManager.createQuery(hql)
				.setParameter(1, "%" + nickname + "%")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findVehicleByModelId(String nickname, String plate, int modelId) {
		String hql = "FROM Vehicle as v WHERE lower(v.nickname) like lower(?) and lower(v.plate) like lower(?) and v.modelId = ?";
		return (List<Vehicle>) entityManager.createQuery(hql)
				.setParameter(1, "%" + nickname + "%")
				.setParameter(2, "%" + plate + "%")
				.setParameter(3, modelId)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findVehicleByTypeOfVehicle(String nickname, String plate, byte typeId) {
		String hql = "FROM Vehicle as v WHERE lower(v.nickname) like lower(?) and lower(v.plate) like lower(?) and v.typeOfVehicle = ?";
		return (List<Vehicle>) entityManager.createQuery(hql)
				.setParameter(1, "%" + nickname + "%")
				.setParameter(2, "%" + plate + "%")
				.setParameter(3, typeId)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findVehicle(String nickname, String plate, int modelId, byte typeId) {
		String hql = "FROM Vehicle as v WHERE lower(v.nickname) like lower(?) and lower(v.plate) like lower(?) and v.modelId = ? and v.typeOfVehicle = ?";
		return (List<Vehicle>) entityManager.createQuery(hql)
				.setParameter(1, "%" + nickname + "%")
				.setParameter(2, "%" + plate + "%")
				.setParameter(3, modelId)
				.setParameter(4, typeId)
				.getResultList();
	}

}
