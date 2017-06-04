package org.duncan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import org.duncan.entity.Vehicle;
import org.duncan.service.IModelService;
import org.duncan.service.IVehicleService;

@RestController
@RequestMapping("/duncan")
public class VehicleController {

	@Autowired
	private IVehicleService vehicleService;

	@Autowired
	private IModelService modelService;

	private ModelAndView modelAndView;

	public VehicleController() {
		modelAndView = new ModelAndView();
		modelAndView.addObject("toolbarList", "/vehicle");
		modelAndView.addObject("toolbarNew", "/vehicle/new");
		modelAndView.setViewName("home");
	}

	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
	public ModelAndView vehicleHome(){
		modelAndView.addObject("vehicle", new Vehicle());
		modelAndView.addObject("page", "vehicleTable");
		modelAndView.addObject("models", modelService.getAllModels());
		modelAndView.addObject("vehicles", vehicleService.getAllVehicles());
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle", method = RequestMethod.POST)
	public ModelAndView searchVehicle(@Valid Vehicle vehicle, BindingResult bindingResult){
		if(vehicle.getModelId() > 0 && vehicle.getTypeOfVehicle() > 0){
			modelAndView.addObject(
					"vehicles", 
					vehicleService.findVehicle(
							vehicle.getNickname(), 
							vehicle.getPlate(), 
							vehicle.getModelId(), 
							vehicle.getTypeOfVehicle()
							)
					);
		}
		
		if(vehicle.getModelId() > 0 && !(vehicle.getTypeOfVehicle() > 0)){
			modelAndView.addObject(
					"vehicles",
					vehicleService.findVehicleByModelId(
							vehicle.getNickname(), 
							vehicle.getPlate(), 
							vehicle.getModelId()
							)
					);
		}
		
		if(!(vehicle.getModelId() > 0) && vehicle.getTypeOfVehicle() > 0){
			modelAndView.addObject(
					"vehicles",
					vehicleService.findVehicleByTypeOfVehicle(
							vehicle.getNickname(), 
							vehicle.getPlate(), 
							vehicle.getTypeOfVehicle()
							)
					);
		}
		
		if(!(vehicle.getModelId() > 0) && !(vehicle.getTypeOfVehicle() > 0)){
			modelAndView.addObject(
					"vehicles",
					vehicleService.findVehicleByNicknameWithPlate(
							vehicle.getNickname(), 
							vehicle.getPlate()
							)
					);
		}

		modelAndView.addObject("vehicle", vehicle);
		modelAndView.addObject("page", "vehicleTable");
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/new", method = RequestMethod.GET)
	public ModelAndView newVehicle(){
		modelAndView.addObject("successMessage", "");
		modelAndView.addObject("link", "/new");
		modelAndView.addObject("vehicle", new Vehicle());
		modelAndView.addObject("page", "vehicleForm");
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/new", method = RequestMethod.POST)
	public ModelAndView createNewVehicle(@Valid Vehicle vehicle, BindingResult bindingResult){
		if(vehicle.getYear() < 1990){
			bindingResult
			.rejectValue("year", "error.vehicle", "*The year must have at least 1990");
		}

		if(vehicle.getTypeOfVehicle() < 1){
			bindingResult
			.rejectValue("typeOfVehicle", "error.vehicle", "*Invalid type of vehicle");
		}

		if(!bindingResult.hasErrors()){
			vehicleService.saveVehicle(vehicle);
			modelAndView.addObject("successMessage", "Vehicle has been registered successfully");
			modelAndView.addObject("vehicle", new Vehicle());
		}

		modelAndView.addObject("link", "/new");
		modelAndView.addObject("page", "vehicleForm");
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateModeVehicle(@PathVariable("id") int id){
		modelAndView.addObject("successMessage", "");
		modelAndView.addObject("vehicle", vehicleService.getVehicleById(id));
		modelAndView.addObject("link", "/update/" + id);
		modelAndView.addObject("page", "vehicleForm");
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/update/{id}", method = RequestMethod.POST)
	public ModelAndView updateModel(@PathVariable("id") int id, @Valid Vehicle vehicle, BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			vehicle.setId(id);
			vehicleService.updateVehicle(vehicle);
			modelAndView.addObject("successMessage", "Vehicle has been updated successfully");
		}

		modelAndView.addObject("vehicle", vehicle);
		modelAndView.addObject("link", "/update/" + id);
		modelAndView.addObject("page", "vehicleForm");
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/remove/{id}", method = RequestMethod.GET)
	public ModelAndView deleteVehicle(@PathVariable("id") int id){
		vehicleService.deleteVehicle(id);
		modelAndView.addObject("vehicles", vehicleService.getAllVehicles());
		modelAndView.addObject("page", "vehicleTable");
		return modelAndView;
	}

}
