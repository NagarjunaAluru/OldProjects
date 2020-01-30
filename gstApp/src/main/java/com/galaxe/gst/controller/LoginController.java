package com.galaxe.gst.controller;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.galaxe.gst.models.login.Users;

/**
 * 
 * @author naluru
 *
 */
@Controller
public class LoginController {

	@RequestMapping(value = { "/"})
	public ModelAndView getUserDefault() {
		return new ModelAndView("login", "users", new Users());
	}
	
	/*@RequestMapping(value = {"/" , "/home" })
	public String getHomePage() {
		return "home";
	}*/

	@RequestMapping("/login")
	public ModelAndView getLoginForm(@ModelAttribute Users users,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		String message = "";
		if (error != null) {
			message = "Incorrect username or password !";
		} else if (logout != null) {
			message = "Logout successful !";
		}
		return new ModelAndView("login", "message", message);
	}

	@RequestMapping("/admin**")
	public String getAdminProfile() {
		return "admin";
	}
	
	@RequestMapping("/home**")
	public String getHomeProfile() {
		return "home";
	}
	
	@RequestMapping("/hr**")
	public String getHRProfile() {
		return "hr";
	}
	
	@RequestMapping("/applicant**")
	public String getApplicantProfile() {
		return "applicant";
	}
	
	@RequestMapping("/trainer**")
	public String getTrainerProfile() {
		return "trainer";
	}
	
	@RequestMapping("/trainee**")
	public String getTraineeProfile() {
		return "trainee";
	}

	@RequestMapping("/403")
	public ModelAndView getAccessDenied() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String username = "";
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = auth != null?(UserDetails) auth.getPrincipal():null;
			username = userDetail != null?userDetail.getUsername():"";
		}

		return new ModelAndView("errorPage", "username", username);
	}

}
