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

import com.mypackage.gestion2.model.Reportprojectsupplierout;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.ReportprojectsupplieroutService;
import com.mypackage.gestion2.web.command.ReportprojectsupplieroutSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;



@Controller
@RequestMapping(value = "/reportprojectsupplierout")
public class ReportprojectsupplieroutController extends BaseCrudController<Reportprojectsupplierout>{
	
	@Resource
	private ReportprojectsupplieroutService reportprojectsupplieroutService;

	
	
	@Override
	protected BaseService<Reportprojectsupplierout> getService() {
		return reportprojectsupplieroutService;
	}

	@Override
	protected String getViewFolder() {
		return "reportprojectsupplierout";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(ReportprojectsupplieroutSearchCommand searchCommand, Model model){
		Page<Reportprojectsupplierout> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<Reportprojectsupplierout> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}



	@ModelAttribute("Reportprojectsupplierout")
	public Reportprojectsupplierout loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Reportprojectsupplierout reportprojectsupplierout = reportprojectsupplieroutService.getOne(new Long(id));
			return reportprojectsupplierout;
		}
		else{
			return new Reportprojectsupplierout();
		}
	}

}
