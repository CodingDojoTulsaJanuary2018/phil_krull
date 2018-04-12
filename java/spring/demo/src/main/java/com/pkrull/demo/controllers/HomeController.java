package com.pkrull.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "Phil");
		return "index.jsp";
//		return "forward:/index";
	}
	
	@RequestMapping("/show")
	public String show() {
		return "response from show()";
	}
}
