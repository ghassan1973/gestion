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

import com.mypackage.gestion2.model.Order;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.OrderService;
import com.mypackage.gestion2.web.command.OrderSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;


import com.mypackage.gestion2.service.ProjectService;
import com.mypackage.gestion2.model.Project;
import com.mypackage.gestion2.service.TierService;
import com.mypackage.gestion2.model.Tier;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseCrudController<Order>{

	@Resource
	private OrderService orderService;


	@Resource
	private ProjectService projectService; 
	@Resource
	private TierService tierService; 

	@Override
	protected BaseService<Order> getService() {
		return orderService;
	}

	@Override
	protected String getViewFolder() {
		return "order";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(OrderSearchCommand searchCommand, Model model){
		Page<Order> list = getService().search(searchCommand);
		model.addAttribute("page", list);

		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<Order> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("order",new Order());


		modelMap.put("all_project",projectService.listAll());
		modelMap.put("all_tier",tierService.listAll());

		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("order",new Order());


		modelMap.put("all_project",projectService.listAll());
		modelMap.put("all_tier",tierService.listAll());

		Order order = orderService.getOne(id);

		modelMap.put("order",order);

		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}


	@ModelAttribute("order")
	public Order loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Order order = orderService.getOne(new Long(id));
			return order;
		}
		else{
			return new Order();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createOrder(@ModelAttribute("order") Order model,HttpServletRequest request) {



		// Many To Ones

		String project_rel = request.getParameter("project_rel");

		if (project_rel != null){

			Project project = projectService.getOne(new Long(project_rel));

			model.setProject(project);

		}

		// Many To Ones

		String tier_rel = request.getParameter("tier_rel");

		if (tier_rel != null){

			Tier tier = tierService.getOne(new Long(tier_rel));

			model.setTier(tier);

		}

		orderService.saveDomain(model);
		return "redirect:/order";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		orderService.deleteDomain(id);
		return "redirect:/order";
	}
}
