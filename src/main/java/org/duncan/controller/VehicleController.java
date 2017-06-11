package org.duncan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import org.duncan.entity.Vehicle;
import org.duncan.service.IModelService;
import org.duncan.service.IVehicleService;

/**
 * @author crash pointer
 * <p>Controller layer for vehicle processes.</p>
 */
@Controller
@RequestMapping("/duncan")
public class VehicleController {

	@Autowired
	private IVehicleService vehicleService;

	@Autowired
	private IModelService modelService;
	
	public void setModelAndView(ModelAndView modelAndView) {
		modelAndView.addObject("pageTitle", "Vehicle");
		modelAndView.addObject("toolbarList", "/vehicle");
		modelAndView.addObject("toolbarNew", "/vehicle/new");
		modelAndView.setViewName("home");
	}

	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
	public ModelAndView vehicleHome(){
		ModelAndView modelAndView = new ModelAndView();
		setModelAndView(modelAndView);
		
		modelAndView.addObject("vehicle", new Vehicle());
		
		modelAndView.addObject("models", modelService.getAllModels());
		modelAndView.addObject("vehicles", vehicleService.getAllVehicles());
		
		modelAndView.addObject("page", "vehicleTable");
		
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle", method = RequestMethod.POST)
	public ModelAndView searchVehicle(Vehicle vehicle){
		ModelAndView modelAndView = new ModelAndView();
		setModelAndView(modelAndView);

		modelAndView.addObject("models", modelService.getAllModels());
		modelAndView.addObject(
				"vehicles",
				vehicleService.findVehicle(
						vehicle.getNickname(), 
						vehicle.getPlate(),
						vehicle.getModel().getId(),
						vehicle.getTypeOfVehicle()
						)
				);

		modelAndView.addObject("vehicle", vehicle);
		modelAndView.addObject("page", "vehicleTable");
		
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/new", method = RequestMethod.GET)
	public ModelAndView newVehicle(){
		ModelAndView modelAndView = new ModelAndView();
		setModelAndView(modelAndView);
		
		modelAndView.addObject("link", "/new");
		modelAndView.addObject("vehicle", new Vehicle());
		modelAndView.addObject("models", modelService.getAllModels());
		modelAndView.addObject("page", "vehicleForm");
		
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/new", method = RequestMethod.POST)
	public ModelAndView createNewVehicle(@Valid Vehicle vehicle, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		setModelAndView(modelAndView);
		
		if(vehicleService.vehicleExists(vehicle.getNickname(), vehicle.getPlate())){
			bindingResult.rejectValue("nickname", "error.vehicle",
					"*There is already a vehicle registered with the nickname or plate provided");
		}
		
		if(!vehicle.getPlate().matches("^[0-9]{2}[A-Za-z]{1,3}[0-9]{2,4}$")){
			bindingResult.rejectValue("plate", "error.vehicle", "*Please check invalid a plate");			
		}
		
		if(!bindingResult.hasErrors()){
			vehicleService.saveVehicle(vehicle);
			modelAndView.addObject("successMessage", "Vehicle has been registered successfully");
			modelAndView.addObject("vehicle", new Vehicle());
		}

		modelAndView.addObject("models", modelService.getAllModels());

		modelAndView.addObject("link", "/new");
		modelAndView.addObject("page", "vehicleForm");
		
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateModeVehicle(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		setModelAndView(modelAndView);
		
		modelAndView.addObject("models", modelService.getAllModels());
		
		modelAndView.addObject("vehicle", vehicleService.getVehicleById(id));
		modelAndView.addObject("link", "/update/" + id);
		modelAndView.addObject("page", "vehicleForm");
		
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/update/{id}", method = RequestMethod.POST)
	public ModelAndView updateModel(@PathVariable("id") int id, @Valid Vehicle vehicle, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		setModelAndView(modelAndView);
		
		if(!bindingResult.hasErrors()){
			vehicle.setId(id);
			vehicleService.updateVehicle(vehicle);
			modelAndView.addObject("successMessage", "Vehicle has been updated successfully");
		}

		modelAndView.addObject("models", modelService.getAllModels());

		modelAndView.addObject("vehicle", vehicle);
		modelAndView.addObject("link", "/update/" + id);
		modelAndView.addObject("page", "vehicleForm");
		
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/remove/{id}", method = RequestMethod.GET)
	public ModelAndView deleteVehicle(@PathVariable("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		setModelAndView(modelAndView);
		
		vehicleService.deleteVehicle(id);
		
		modelAndView.addObject("models", modelService.getAllModels());
		modelAndView.addObject("vehicles", vehicleService.getAllVehicles());

		modelAndView.addObject("vehicle", new Vehicle());
		modelAndView.addObject("page", "vehicleTable");
		
		return modelAndView;
	}

}
