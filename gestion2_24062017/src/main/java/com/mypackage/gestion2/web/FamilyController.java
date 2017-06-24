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

import com.mypackage.gestion2.model.Family;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.FamilyService;
import com.mypackage.gestion2.web.command.FamilySearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;



@Controller
@RequestMapping(value = "/family")
public class FamilyController extends BaseCrudController<Family>{
	
	@Resource
	private FamilyService familyService;

	
	
	@Override
	protected BaseService<Family> getService() {
		return familyService;
	}

	@Override
	protected String getViewFolder() {
		return "family";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(FamilySearchCommand searchCommand, Model model){
		Page<Family> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<Family> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("family",new Family());

				
		
		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("family",new Family());

				
		
		Family family = familyService.getOne(id);
		
		modelMap.put("family",family);

		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}


	@ModelAttribute("family")
	public Family loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Family family = familyService.getOne(new Long(id));
			return family;
		}
		else{
			return new Family();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createFamily(@ModelAttribute("family") Family model,HttpServletRequest request) {
		
				
		
		familyService.saveDomain(model);
		return "redirect:/family";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		familyService.deleteDomain(id);
		return "redirect:/family";
	}
}
