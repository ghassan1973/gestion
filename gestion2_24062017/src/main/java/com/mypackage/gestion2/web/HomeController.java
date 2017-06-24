package com.mypackage.gestion2.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mypackage.gestion2.service.OrderService;
import com.mypackage.gestion2.service.ProjectService;
import com.mypackage.gestion2.service.TierService;
import com.mypackage.gestion2.service.TransactionService;

@Controller
public class HomeController {
	
	@Resource
	TransactionService transactionService;

	@Resource
	ProjectService projectService;
	@Resource
	OrderService orderService;
	@Resource
	TierService tierService;

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(HttpServletRequest request,Model model){
		request.getSession().setAttribute("me", SecurityContextHolder.getContext().getAuthentication().getPrincipal());

		model.addAttribute("count_transaction",transactionService.countAll());

				
		model.addAttribute("count_project",projectService.countAll());
		
				
		model.addAttribute("count_order",orderService.countAll());
		
				
		model.addAttribute("count_tier",tierService.countAll());
		
		
		return "common/home";
	}
}
