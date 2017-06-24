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

import com.mypackage.gestion2.model.Tier;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.TierService;
import com.mypackage.gestion2.web.command.TierSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;


import com.mypackage.gestion2.service.FamilyTierService;
import com.mypackage.gestion2.model.FamilyTier;

@Controller
@RequestMapping(value = "/tier")
public class TierController extends BaseCrudController<Tier>{
	
	@Resource
	private TierService tierService;

	
		@Resource
	private FamilyTierService familyTierService; 
	
	@Override
	protected BaseService<Tier> getService() {
		return tierService;
	}

	@Override
	protected String getViewFolder() {
		return "tier";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(TierSearchCommand searchCommand, Model model){
		Page<Tier> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<Tier> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("tier",new Tier());

				
				modelMap.put("all_familyTier",familyTierService.listAll());
		
		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("tier",new Tier());

				
				modelMap.put("all_familyTier",familyTierService.listAll());
		
		Tier tier = tierService.getOne(id);
		
		modelMap.put("tier",tier);

		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}


	@ModelAttribute("tier")
	public Tier loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Tier tier = tierService.getOne(new Long(id));
			return tier;
		}
		else{
			return new Tier();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createTier(@ModelAttribute("tier") Tier model,HttpServletRequest request) {
		
				
		
		// Many To Ones

		String familyTier_rel = request.getParameter("familyTier_rel");
		
		if (familyTier_rel != null){

            FamilyTier familyTier = familyTierService.getOne(new Long(familyTier_rel));

            model.setFamilyTier(familyTier);

		}
		
		tierService.saveDomain(model);
		return "redirect:/tier";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		tierService.deleteDomain(id);
		return "redirect:/tier";
	}
}
