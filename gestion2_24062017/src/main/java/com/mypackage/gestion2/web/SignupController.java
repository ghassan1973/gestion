package com.mypackage.gestion2.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mypackage.gestion2.model.SignupRequest;
import com.mypackage.gestion2.model.User;
import com.mypackage.gestion2.service.SignupRequestService;
import com.mypackage.gestion2.service.UserService;

@Controller
public class SignupController {

	@Resource
	private UserService userService;

	@Resource
	private SignupRequestService signupRequestService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage() {
		return "common/register";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String registerUser(User user, Model model) {
		userService.signup(user);
		return "common/register_confirm";
	}

	@RequestMapping(value = "/signup/activate/{token}", method = RequestMethod.POST)
	public String activateUser(@PathVariable("token") String token, Model model) {
		try {
			SignupRequest findByToken = signupRequestService.findByToken(token);
			if (findByToken == null) {
				model.addAttribute("error", "Invalid Token");
				return "common/register_error";
			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "common/register_error";
		}

		return "common/register_activate";
	}
}
