package org.duncan.controller;

import javax.validation.Valid;

import org.duncan.entity.Model;
import org.duncan.service.BrandService;
import org.duncan.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author crash pointer
 * <p>Controller layer for model processes.</p>
 */
@Controller
@RequestMapping("/duncan")
public class ModelController {

	@Autowired
	private BrandService brandService;

	@Autowired
	private ModelService modelService;

	private ModelAndView modelAndView;

	public ModelController() {
		modelAndView = new ModelAndView();
		modelAndView.addObject("pageTitle", "Model");
		modelAndView.addObject("toolbarList", "/model");
		modelAndView.addObject("toolbarNew", "/model/new");
		modelAndView.setViewName("home");
	}

	@RequestMapping(value = "/model", method = RequestMethod.GET)
	public ModelAndView modelHome(){
		modelAndView.addObject("model", new Model());
		modelAndView.addObject("page", "modelTable");
		modelAndView.addObject("brands", brandService.getAllBrands());
		modelAndView.addObject("models", modelService.getAllModels());
		return modelAndView;
	}
	
	@RequestMapping(value = "/model", method = RequestMethod.POST)
	public ModelAndView searchBrand(@Valid Model model, BindingResult bindingResult){
		modelAndView.addObject("models", modelService.findModel(model.getName(), model.getBrand().getId()));
		modelAndView.addObject("model", model);
		modelAndView.addObject("page", "modelTable");
		return modelAndView;
	}
	
	@RequestMapping(value = "/model/new", method = RequestMethod.GET)
	public ModelAndView newModel(){
		modelAndView.addObject("successMessage", "");
		modelAndView.addObject("link", "/new");
		modelAndView.addObject("model", new Model());
		modelAndView.addObject("page", "modelForm");
		return modelAndView;
	}

	@RequestMapping(value = "/model/new", method = RequestMethod.POST)
	public ModelAndView createNewBrand(@Valid Model model, BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			modelService.saveModel(model);
			modelAndView.addObject("successMessage", "Model has been registered successfully");
			modelAndView.addObject("model", new Model());
		}
		
		modelAndView.addObject("link", "/new");
		modelAndView.addObject("page", "modelForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/model/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateModeModel(@PathVariable("id") int id){
		modelAndView.addObject("successMessage", "");
		modelAndView.addObject("model", modelService.getModelById(id));
		modelAndView.addObject("link", "/update/" + id);
		modelAndView.addObject("page", "modelForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/model/update/{id}", method = RequestMethod.POST)
	public ModelAndView updateModel(@PathVariable("id") int id, @Valid Model model, BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			model.setId(id);
			modelService.updateModel(model);
			modelAndView.addObject("successMessage", "Model has been updated successfully");
		}

		modelAndView.addObject("model", model);
		modelAndView.addObject("link", "/update/" + id);
		modelAndView.addObject("page", "modelForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/model/remove/{id}", method = RequestMethod.GET)
	public ModelAndView deleteModel(@PathVariable("id") int id){
		modelService.deleteModel(id);
		modelAndView.addObject("models", modelService.getAllModels());
		modelAndView.addObject("page", "modelTable");
		return modelAndView;
	}

}
