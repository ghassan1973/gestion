package com.mypackage.gestion2.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mypackage.gestion2.model.User;
import com.mypackage.gestion2.service.UserService;

@Controller
public class ProfileController {
	
	@Resource
	private UserService userService;
	
	@ModelAttribute("user")
	public User loadUser(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userService.getOne(user.getUserId());
	}

	@RequestMapping(value = "/myProfile", method = RequestMethod.GET)
	public String showProfile(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User me = userService.getOne(user.getUserId());
		model.addAttribute("user", me);
		return "common/myProfile";
	}

	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("user") User user, Model model,HttpServletRequest request) {

		if (StringUtils.isEmpty(user.getFirstName())) {
			model.addAttribute("error", "First Name is mandatory field");
			return "common/myProfile";
		}

		if (StringUtils.isEmpty(user.getLastName())) {
			model.addAttribute("error", "Last Name is mandatory field");
			return "common/myProfile";
		}

		if (StringUtils.isEmpty(user.getPassword())) {
			model.addAttribute("error", "Password is mandatory field");
			return "common/myProfile";
		}

		userService.saveDomain(user);

		request.getSession().setAttribute("me", SecurityContextHolder.getContext().getAuthentication().getPrincipal());

		model.addAttribute("message", "Profile updated sucessfully");

		return "common/myProfile";
	}
}
