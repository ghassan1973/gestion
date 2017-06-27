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

import com.mypackage.gestion2.model.ProjectType;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.ProjectTypeService;
import com.mypackage.gestion2.web.command.ProjectTypeSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;



@Controller
@RequestMapping(value = "/projectType")
public class ProjectTypeController extends BaseCrudController<ProjectType>{
	
	@Resource
	private ProjectTypeService projectTypeService;

	
	
	@Override
	protected BaseService<ProjectType> getService() {
		return projectTypeService;
	}

	@Override
	protected String getViewFolder() {
		return "projecttype";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(ProjectTypeSearchCommand searchCommand, Model model){
		Page<ProjectType> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<ProjectType> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("projectType",new ProjectType());

				
		
		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("projectType",new ProjectType());

				
		
		ProjectType projectType = projectTypeService.getOne(id);
		
		modelMap.put("projectType",projectType);

		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}


	@ModelAttribute("projectType")
	public ProjectType loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			ProjectType projectType = projectTypeService.getOne(new Long(id));
			return projectType;
		}
		else{
			return new ProjectType();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createProjectType(@ModelAttribute("projectType") ProjectType model,HttpServletRequest request) {
		
				
		
		projectTypeService.saveDomain(model);
		return "redirect:/projectType";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		projectTypeService.deleteDomain(id);
		return "redirect:/projectType";
	}
}
