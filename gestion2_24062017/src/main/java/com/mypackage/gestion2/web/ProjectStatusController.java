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

import com.mypackage.gestion2.model.ProjectStatus;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.ProjectStatusService;
import com.mypackage.gestion2.web.command.ProjectStatusSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;



@Controller
@RequestMapping(value = "/projectStatus")
public class ProjectStatusController extends BaseCrudController<ProjectStatus>{
	
	@Resource
	private ProjectStatusService projectStatusService;

	
	
	@Override
	protected BaseService<ProjectStatus> getService() {
		return projectStatusService;
	}

	@Override
	protected String getViewFolder() {
		return "projectstatus";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(ProjectStatusSearchCommand searchCommand, Model model){
		Page<ProjectStatus> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<ProjectStatus> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("projectStatus",new ProjectStatus());

				
		
		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("projectStatus",new ProjectStatus());

				
		
		ProjectStatus projectStatus = projectStatusService.getOne(id);
		
		modelMap.put("projectStatus",projectStatus);

		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}


	@ModelAttribute("projectStatus")
	public ProjectStatus loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			ProjectStatus projectStatus = projectStatusService.getOne(new Long(id));
			return projectStatus;
		}
		else{
			return new ProjectStatus();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createProjectStatus(@ModelAttribute("projectStatus") ProjectStatus model,HttpServletRequest request) {
		
				
		
		projectStatusService.saveDomain(model);
		return "redirect:/projectStatus";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		projectStatusService.deleteDomain(id);
		return "redirect:/projectStatus";
	}
}
