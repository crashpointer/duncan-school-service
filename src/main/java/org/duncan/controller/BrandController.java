package org.duncan.controller;

import javax.validation.Valid;

import org.duncan.entity.Brand;
import org.duncan.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author crash pointer
 * 
 */
@Controller
@RequestMapping("/duncan")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	private ModelAndView modelAndView;
	
	public BrandController() {
		modelAndView = new ModelAndView();
		modelAndView.addObject("pageTitle", "Brand");
		modelAndView.addObject("toolbarList", "/brand");
		modelAndView.addObject("toolbarNew", "/brand/new");
		modelAndView.setViewName("home");
	}
	
	@RequestMapping(value = "/brand", method = RequestMethod.GET)
	public ModelAndView brandHome(){
		modelAndView.addObject("brand", new Brand());
		modelAndView.addObject("page", "brandTable");
		modelAndView.addObject("list", brandService.getAllBrands());
		return modelAndView;
	}
	
	@RequestMapping(value = "/brand", method = RequestMethod.POST)
	public ModelAndView searchBrand(@Valid Brand brand, BindingResult bindingResult){
		modelAndView.addObject("list", brandService.findBrand(brand.getName()));
		modelAndView.addObject("brand", brand);
		modelAndView.addObject("page", "brandTable");
		return modelAndView;
	}
	
	@RequestMapping(value = "/brand/new", method = RequestMethod.GET)
	public ModelAndView newBrand(){
		modelAndView.addObject("successMessage", "");
		modelAndView.addObject("link", "/new");
		modelAndView.addObject("brand", new Brand());
		modelAndView.addObject("page", "brandForm");
		return modelAndView;
	}

	@RequestMapping(value = "/brand/new", method = RequestMethod.POST)
	public ModelAndView createNewBrand(@Valid Brand brand, BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			brandService.saveBrand(brand);
			modelAndView.addObject("successMessage", "Brand has been registered successfully");
			modelAndView.addObject("brand", new Brand());
		}
		
		modelAndView.addObject("link", "/new");
		modelAndView.addObject("page", "brandForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/brand/update/{id}", method = RequestMethod.GET)
	public ModelAndView updateModeBrand(@PathVariable("id") int id){
		modelAndView.addObject("successMessage", "");
		modelAndView.addObject("brand", brandService.getBrandById(id));
		modelAndView.addObject("link", "/update/" + id);
		modelAndView.addObject("page", "brandForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/brand/update/{id}", method = RequestMethod.POST)
	public ModelAndView updateBrand(@PathVariable("id") int id, @Valid Brand brand, BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			brand.setId(id);
			brandService.updateBrand(brand);
			modelAndView.addObject("successMessage", "Brand has been updated successfully");
		}

		modelAndView.addObject("brand", brand);
		modelAndView.addObject("link", "/update/" + id);
		modelAndView.addObject("page", "brandForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/brand/remove/{id}", method = RequestMethod.GET)
	public ModelAndView deleteBrand(@PathVariable("id") int id){
		brandService.deleteBrand(id);
		modelAndView.addObject("list", brandService.getAllBrands());
		modelAndView.addObject("page", "brandTable");
		return modelAndView;
	}
	
}
