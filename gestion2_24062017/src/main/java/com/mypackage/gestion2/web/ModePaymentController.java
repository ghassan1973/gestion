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

import com.mypackage.gestion2.model.ModePayment;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.ModePaymentService;
import com.mypackage.gestion2.web.command.ModePaymentSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;



@Controller
@RequestMapping(value = "/modePayment")
public class ModePaymentController extends BaseCrudController<ModePayment>{
	
	@Resource
	private ModePaymentService modePaymentService;

	
	
	@Override
	protected BaseService<ModePayment> getService() {
		return modePaymentService;
	}

	@Override
	protected String getViewFolder() {
		return "modepayment";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(ModePaymentSearchCommand searchCommand, Model model){
		Page<ModePayment> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<ModePayment> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("modePayment",new ModePayment());

				
		
		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("modePayment",new ModePayment());

				
		
		ModePayment modePayment = modePaymentService.getOne(id);
		
		modelMap.put("modePayment",modePayment);

		return new ModelAndView(getViewFolder() + "/create",modelMap);
	}


	@ModelAttribute("modePayment")
	public ModePayment loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			ModePayment modePayment = modePaymentService.getOne(new Long(id));
			return modePayment;
		}
		else{
			return new ModePayment();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createModePayment(@ModelAttribute("modePayment") ModePayment model,HttpServletRequest request) {
		
				
		
		modePaymentService.saveDomain(model);
		return "redirect:/modePayment";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		modePaymentService.deleteDomain(id);
		return "redirect:/modePayment";
	}
}
