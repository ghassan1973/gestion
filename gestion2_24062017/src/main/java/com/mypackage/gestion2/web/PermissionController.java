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

import com.mypackage.gestion2.model.Permission;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.PermissionService;
import com.mypackage.gestion2.web.command.PermissionSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;



@Controller
@RequestMapping(value = "/permission")
public class PermissionController extends BaseCrudController<Permission>{
	
	@Resource
	private PermissionService permissionService;

	
	
	@Override
	protected BaseService<Permission> getService() {
		return permissionService;
	}

	@Override
	protected String getViewFolder() {
		return "permission";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(PermissionSearchCommand searchCommand, Model model){
		Page<Permission> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<Permission> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("permission",new Permission());

				
		
		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("permission",new Permission());

				
		
		Permission permission = permissionService.getOne(id);
		
		modelMap.put("permission",permission);

		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}


	@ModelAttribute("permission")
	public Permission loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Permission permission = permissionService.getOne(new Long(id));
			return permission;
		}
		else{
			return new Permission();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createPermission(@ModelAttribute("permission") Permission model,HttpServletRequest request) {
		
				
		
		permissionService.saveDomain(model);
		return "redirect:/permission";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		permissionService.deleteDomain(id);
		return "redirect:/permission";
	}
}
