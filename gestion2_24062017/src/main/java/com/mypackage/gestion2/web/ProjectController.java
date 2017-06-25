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

import com.mypackage.gestion2.model.Project;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.ProjectService;
import com.mypackage.gestion2.web.command.ProjectSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;


import com.mypackage.gestion2.service.RegionService;
import com.mypackage.gestion2.model.Region;
import com.mypackage.gestion2.service.ProjectTypeService;
import com.mypackage.gestion2.model.ProjectType;
import com.mypackage.gestion2.service.ProjectStatusService;
import com.mypackage.gestion2.model.ProjectStatus;

@Controller
@RequestMapping(value = "/project")
public class ProjectController extends BaseCrudController<Project>{
	
	@Resource
	private ProjectService projectService;

	
		@Resource
	private RegionService regionService; 
		@Resource
	private ProjectTypeService projectTypeService; 
		@Resource
	private ProjectStatusService projectStatusService; 
	
	@Override
	protected BaseService<Project> getService() {
		return projectService;
	}

	@Override
	protected String getViewFolder() {
		return "project";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(ProjectSearchCommand searchCommand, Model model){
		Page<Project> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<Project> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("project",new Project());

				
				modelMap.put("all_region",regionService.listAll());
				modelMap.put("all_projectType",projectTypeService.listAll());
				modelMap.put("all_projectStatus",projectStatusService.listAll());
		
		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("project",new Project());

				
				modelMap.put("all_region",regionService.listAll());
				modelMap.put("all_projectType",projectTypeService.listAll());
				modelMap.put("all_projectStatus",projectStatusService.listAll());
		
		Project project = projectService.getOne(id);
		
		modelMap.put("project",project);

		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}


	@ModelAttribute("project")
	public Project loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Project project = projectService.getOne(new Long(id));
			return project;
		}
		else{
			return new Project();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createProject(@ModelAttribute("project") Project model,HttpServletRequest request) {
		
				
		
		// Many To Ones

		String region_rel = request.getParameter("region_rel");
		
		if (region_rel != null){

            Region region = regionService.getOne(new Long(region_rel));

            model.setRegion(region);

		}
		
		// Many To Ones

		String projectType_rel = request.getParameter("projectType_rel");
		
		if (projectType_rel != null){

            ProjectType projectType = projectTypeService.getOne(new Long(projectType_rel));

            model.setProjectType(projectType);

		}
		
		// Many To Ones

		String projectStatus_rel = request.getParameter("projectStatus_rel");
		
		if (projectStatus_rel != null){

            ProjectStatus projectStatus = projectStatusService.getOne(new Long(projectStatus_rel));

            model.setProjectStatus(projectStatus);

		}
		
		projectService.saveDomain(model);
		return "redirect:/project";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		projectService.deleteDomain(id);
		return "redirect:/project";
	}
}
