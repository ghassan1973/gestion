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

import com.mypackage.gestion2.model.Role;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.RoleService;
import com.mypackage.gestion2.web.command.RoleSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;

import com.mypackage.gestion2.service.PermissionService;
import com.mypackage.gestion2.model.Permission;


@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseCrudController<Role>{
	
	@Resource
	private RoleService roleService;

		@Resource
	private PermissionService permissionService; 
	
	
	@Override
	protected BaseService<Role> getService() {
		return roleService;
	}

	@Override
	protected String getViewFolder() {
		return "role";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(RoleSearchCommand searchCommand, Model model){
		Page<Role> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<Role> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("role",new Role());

				modelMap.put("all_permission",permissionService.listAll());
				
		
		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("role",new Role());

				modelMap.put("all_permission",permissionService.listAll());
				
		
		Role role = roleService.getOne(id);
		
		modelMap.put("role",role);

		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}


	@ModelAttribute("role")
	public Role loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Role role = roleService.getOne(new Long(id));
			return role;
		}
		else{
			return new Role();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createRole(@ModelAttribute("role") Role model,HttpServletRequest request) {
		
				String[] permissions = request.getParameterValues("permissions_rel");
		// Many To Many
		if (permissions != null){

			if(model.getPermissions() != null){
				model.getPermissions().clear();
			}else
			{
				model.setPermissions(new ArrayList<Permission>());
			}

			for ( String id : permissions){
				Permission permission = permissionService.getOne(new Long(id));
				model.getPermissions().add(permission);
			}	
		}
				
		
		roleService.saveDomain(model);
		return "redirect:/role";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		roleService.deleteDomain(id);
		return "redirect:/role";
	}
}
