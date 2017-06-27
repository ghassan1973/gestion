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

import com.mypackage.gestion2.model.User;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.UserService;
import com.mypackage.gestion2.web.command.UserSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;

import com.mypackage.gestion2.service.RoleService;
import com.mypackage.gestion2.model.Role;


@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseCrudController<User>{
	
	@Resource
	private UserService userService;

		@Resource
	private RoleService roleService; 
	
	
	@Override
	protected BaseService<User> getService() {
		return userService;
	}

	@Override
	protected String getViewFolder() {
		return "user";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(UserSearchCommand searchCommand, Model model){
		Page<User> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<User> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("user",new User());

				modelMap.put("all_role",roleService.listAll());
				
		
		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("user",new User());

				modelMap.put("all_role",roleService.listAll());
				
		
		User user = userService.getOne(id);
		
		modelMap.put("user",user);

		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}


	@ModelAttribute("user")
	public User loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			User user = userService.getOne(new Long(id));
			return user;
		}
		else{
			return new User();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User model,HttpServletRequest request) {
		
				String[] roles = request.getParameterValues("roles_rel");
		// Many To Many
		if (roles != null){

			if(model.getRoles() != null){
				model.getRoles().clear();
			}else
			{
				model.setRoles(new ArrayList<Role>());
			}

			for ( String id : roles){
				Role role = roleService.getOne(new Long(id));
				model.getRoles().add(role);
			}	
		}
				
		
		userService.saveDomain(model);
		return "redirect:/user";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		userService.deleteDomain(id);
		return "redirect:/user";
	}
}
