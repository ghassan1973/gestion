package com.mypackage.gestion2.web;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mypackage.gestion2.model.ForgotPasswordRequest;
import com.mypackage.gestion2.model.User;
import com.mypackage.gestion2.service.ForgotPasswordRequestService;
import com.mypackage.gestion2.service.UserService;

@Controller
public class LoginController {

    @Resource
    private ForgotPasswordRequestService forgotPasswordRequestService;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login")
        public String showLoginPage() {
        return "common/login";
    }

    @RequestMapping(value = "/signin/forgot_password", method = RequestMethod.GET)
    public String forgotPassword() {
     return "common/forgot_password";
    }

    @RequestMapping(value = "/signin/forgot_password", method = RequestMethod.POST)
    public String resetPassword(String email, Model model) {
        User user = userService.findByEmail(email);
        if (user == null) {
            model.addAttribute("error", "No such user found");
            return "common/forgot_password";
        } else {
            ForgotPasswordRequest req = new ForgotPasswordRequest();
            req.setUser(user);
            req.setCreatedOn(new Date());
            Calendar calendar = Calendar.getInstance();
            calendar.add(calendar.DATE, 1);
            req.setExpiresOn(calendar.getTime());

            req.setTokenId(UUID.randomUUID().toString());

            forgotPasswordRequestService.saveDomain(req);

            return "common/reset_password_confirm";
        }
    }

    @RequestMapping(value = "/signin/change_password/{token}", method = RequestMethod.GET)
    public String showChangePasswordPage(@PathVariable("token") String token, Model model) {
        try {
            User validateUserToken = forgotPasswordRequestService.validateUserToken(token);
            model.addAttribute("user",validateUserToken);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "common/change_password";
    }

    @RequestMapping(value = "/signin/change_password/{token}", method = RequestMethod.POST)
    public String changePasswordPage(Long userId,String password, Model model) {
        try {
            userService.changePassword(userId, password);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "common/change_password_confirm";
    }


}
