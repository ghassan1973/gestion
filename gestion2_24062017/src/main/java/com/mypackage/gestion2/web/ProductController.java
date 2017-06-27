package com.mypackage.gestion2.web;

import java.util.HashMap;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mypackage.gestion2.model.Product;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.ProductService;
import com.mypackage.gestion2.web.command.ProductSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;


import com.mypackage.gestion2.service.FamilyService;
import com.mypackage.gestion2.model.Family;

@Controller
@RequestMapping(value = "/product")
public class ProductController extends BaseCrudController<Product>{
	
	@Resource
	private ProductService productService;

	
		@Resource
	private FamilyService familyService; 
	
	@Override
	protected BaseService<Product> getService() {
		return productService;
	}

	@Override
	protected String getViewFolder() {
		return "product";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(ProductSearchCommand searchCommand, Model model){
		Page<Product> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<Product> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("product",new Product());

				
				modelMap.put("all_family",familyService.listAll());
		
		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("product",new Product());

				
				modelMap.put("all_family",familyService.listAll());
		
		Product product = productService.getOne(id);
		
		modelMap.put("product",product);

		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}


	@ModelAttribute("product")
	public Product loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Product product = productService.getOne(new Long(id));
			return product;
		}
		else{
			return new Product();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createProduct(@ModelAttribute("product") Product model,HttpServletRequest request) {
		
				
		
		// Many To Ones

		String family_rel = request.getParameter("family_rel");
		
		if (family_rel != null){

            Family family = familyService.getOne(new Long(family_rel));

            model.setFamily(family);

		}
		
		productService.saveDomain(model);
		return "redirect:/product";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		productService.deleteDomain(id);
		return "redirect:/product";
	}
}
