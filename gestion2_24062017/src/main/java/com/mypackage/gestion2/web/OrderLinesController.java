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

import com.mypackage.gestion2.model.OrderLines;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.OrderLinesService;
import com.mypackage.gestion2.web.command.OrderLinesSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;


import com.mypackage.gestion2.service.ProductService;
import com.mypackage.gestion2.model.Product;
import com.mypackage.gestion2.service.OrderService;
import com.mypackage.gestion2.model.Order;

@Controller
@RequestMapping(value = "/orderLines")
public class OrderLinesController extends BaseCrudController<OrderLines>{
	
	@Resource
	private OrderLinesService orderLinesService;

	
		@Resource
	private ProductService productService; 
		@Resource
	private OrderService orderService; 
	
	@Override
	protected BaseService<OrderLines> getService() {
		return orderLinesService;
	}

	@Override
	protected String getViewFolder() {
		return "orderlines";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(OrderLinesSearchCommand searchCommand, Model model){
		Page<OrderLines> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<OrderLines> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("orderLines",new OrderLines());

				
				modelMap.put("all_product",productService.listAll());
				modelMap.put("all_order",orderService.listAll());
		
		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("orderLines",new OrderLines());

				
				modelMap.put("all_product",productService.listAll());
				modelMap.put("all_order",orderService.listAll());
		
		OrderLines orderLines = orderLinesService.getOne(id);
		
		modelMap.put("orderLines",orderLines);

		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}


	@ModelAttribute("orderLines")
	public OrderLines loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			OrderLines orderLines = orderLinesService.getOne(new Long(id));
			return orderLines;
		}
		else{
			return new OrderLines();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createOrderLines(@ModelAttribute("orderLines") OrderLines model,HttpServletRequest request) {
		
				
		
		// Many To Ones

		String product_rel = request.getParameter("product_rel");
		
		if (product_rel != null){

            Product product = productService.getOne(new Long(product_rel));

            model.setProduct(product);

		}
		
		// Many To Ones

		String order_rel = request.getParameter("order_rel");
		
		if (order_rel != null){

            Order order = orderService.getOne(new Long(order_rel));

            model.setOrder(order);

		}
		
		orderLinesService.saveDomain(model);
		return "redirect:/orderLines";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		orderLinesService.deleteDomain(id);
		return "redirect:/orderLines";
	}
}
