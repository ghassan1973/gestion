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

import com.mypackage.gestion2.model.FamilyTier;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.FamilyTierService;
import com.mypackage.gestion2.web.command.FamilyTierSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;



@Controller
@RequestMapping(value = "/familyTier")
public class FamilyTierController extends BaseCrudController<FamilyTier>{
	
	@Resource
	private FamilyTierService familyTierService;

	
	
	@Override
	protected BaseService<FamilyTier> getService() {
		return familyTierService;
	}

	@Override
	protected String getViewFolder() {
		return "familytier";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(FamilyTierSearchCommand searchCommand, Model model){
		Page<FamilyTier> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<FamilyTier> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("familyTier",new FamilyTier());

				
		
		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("familyTier",new FamilyTier());

				
		
		FamilyTier familyTier = familyTierService.getOne(id);
		
		modelMap.put("familyTier",familyTier);

		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}


	@ModelAttribute("familyTier")
	public FamilyTier loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			FamilyTier familyTier = familyTierService.getOne(new Long(id));
			return familyTier;
		}
		else{
			return new FamilyTier();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createFamilyTier(@ModelAttribute("familyTier") FamilyTier model,HttpServletRequest request) {
		
				
		
		familyTierService.saveDomain(model);
		return "redirect:/familyTier";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		familyTierService.deleteDomain(id);
		return "redirect:/familyTier";
	}
}
