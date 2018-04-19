package com.pkrull.april_login_reg.controllers;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pkrull.april_login_reg.models.User;
import com.pkrull.april_login_reg.services.UserDetailsServiceImplementation;
import com.pkrull.april_login_reg.services.UserService;
import com.pkrull.april_login_reg.validations.UserValidator;

@Controller
public class UserController {

	private final UserService uService;
	private final UserValidator uValidator;
	private final UserDetailsServiceImplementation uDetails;
	private org.springframework.security.core.userdetails.User SecurityUser;
	
	public UserController(UserService uService, UserValidator uValidator, UserDetailsServiceImplementation uDetails) {
		// TODO Auto-generated constructor stub
		this.uService = uService;
		this.uValidator = uValidator;
		this.uDetails = uDetails;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user")User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		System.out.println("*****************************");
		if(error != null) {
			System.out.println("error found");
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
		return "index";
	}
	
	@RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        System.out.println("in request login");
		if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        model.addAttribute("user", new User());
        return "index";
    }
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("user")User user, BindingResult result, Model model, HttpServletRequest request, Principal principal) {
		uValidator.validate(user, result);
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			return "index";
		} else {
			// creating redirect to index if not login at register
			// find a way to authenticate at registration
			
			User createdUser = uService.saveWithUserRole(user);
//			try {
//				request.login(createdUser.getEmail(), createdUser.getPassword());				
//			} catch (ServletException e) {
////		        LOGGER.error("Error while login ", e);
//				System.out.println("Error while login " + e.toString());
//		    }
//			org.springframework.security.core.userdetails.User secureUser = (org.springframework.security.core.userdetails.User) uDetails.loadUserByUsername(createdUser.getEmail());
//			System.out.println(secureUser);
////			SecurityContextHolder.Context(secureUser);
			Authentication authentication = new UsernamePasswordAuthenticationToken(createdUser.getEmail(), createdUser.getPassword(), uDetails.getAuthorities(createdUser));
		    SecurityContextHolder.getContext().setAuthentication(authentication);
//			SecurityContextHolder.getContext().setAuthentication(secureUser);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Principal principal, Model model) {
		String email = principal.getName();
		System.out.println("-------------------------------");
		System.out.println(principal.toString());
		User currUser = uService.findByEmail(email);
		uService.updateUser(currUser);
		model.addAttribute("currUser", currUser);
		return "dashboard";
	}

}
