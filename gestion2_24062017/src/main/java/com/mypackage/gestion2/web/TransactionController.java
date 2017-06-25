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

import com.mypackage.gestion2.model.Transaction;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.service.TransactionService;
import com.mypackage.gestion2.web.command.TransactionSearchCommand;
import com.mypackage.gestion2.web.command.SearchCommand;


import com.mypackage.gestion2.service.OrderService;
import com.mypackage.gestion2.model.Order;
import com.mypackage.gestion2.service.CurrencyService;
import com.mypackage.gestion2.model.Currency;
import com.mypackage.gestion2.service.ModePaymentService;
import com.mypackage.gestion2.model.ModePayment;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController extends BaseCrudController<Transaction>{
	
	@Resource
	private TransactionService transactionService;

	
		@Resource
	private OrderService orderService; 
		@Resource
	private CurrencyService currencyService; 
		@Resource
	private ModePaymentService modePaymentService; 
	
	@Override
	protected BaseService<Transaction> getService() {
		return transactionService;
	}

	@Override
	protected String getViewFolder() {
		return "transaction";
	}

	@RequestMapping(value="/search",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String search(TransactionSearchCommand searchCommand, Model model){
		Page<Transaction> list = getService().search(searchCommand);
		model.addAttribute("page", list);
		
		model.addAttribute("search", searchCommand);

		return getViewFolder() + "/list";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			Model model) {
		Page<Transaction> list = getService().getAll(page, size);
		model.addAttribute("page", list);
		return getViewFolder() + "/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("transaction",new Transaction());

				
				modelMap.put("all_order",orderService.listAll());
				modelMap.put("all_currency",currencyService.listAll());
				modelMap.put("all_modePayment",modePaymentService.listAll());
		
		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public ModelAndView showEditPage(@PathVariable("id") Long id, Model model) {

		HashMap<String,Object> modelMap = new HashMap<String,Object>();
		modelMap.put("transaction",new Transaction());

				
				modelMap.put("all_order",orderService.listAll());
				modelMap.put("all_currency",currencyService.listAll());
				modelMap.put("all_modePayment",modePaymentService.listAll());
		
		Transaction transaction = transactionService.getOne(id);
		
		modelMap.put("transaction",transaction);

		return new ModelAndView(getViewFolder() + "/properties",modelMap);
	}


	@ModelAttribute("transaction")
	public Transaction loadModel(HttpServletRequest request){
		String id = request.getParameter("id");
		if(!StringUtils.isEmpty(id)){
			Transaction transaction = transactionService.getOne(new Long(id));
			return transaction;
		}
		else{
			return new Transaction();
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String createTransaction(@ModelAttribute("transaction") Transaction model,HttpServletRequest request) {
		
				
		
		// Many To Ones

		String order_rel = request.getParameter("order_rel");
		
		if (order_rel != null){

            Order order = orderService.getOne(new Long(order_rel));

            model.setOrder(order);

		}
		
		// Many To Ones

		String currency_rel = request.getParameter("currency_rel");
		
		if (currency_rel != null){

            Currency currency = currencyService.getOne(new Long(currency_rel));

            model.setCurrency(currency);

		}
		
		// Many To Ones

		String modePayment_rel = request.getParameter("modePayment_rel");
		
		if (modePayment_rel != null){

            ModePayment modePayment = modePaymentService.getOne(new Long(modePayment_rel));

            model.setModePayment(modePayment);

		}
		
		transactionService.saveDomain(model);
		return "redirect:/transaction";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model){
		transactionService.deleteDomain(id);
		return "redirect:/transaction";
	}
}
