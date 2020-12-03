package com.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
		
	@RequestMapping("/form")
	public String getform() {
		return "form";
	}
	
	@RequestMapping("/submitform")
	public String submitform() {
		return "submitted-form";
	}
	
	@RequestMapping("/getCustomer")
	public String getCustomerData(HttpServletRequest request, Model model) {
		String name = request.getParameter("customerName");
		String result = "Welcome to the website" + name;
		model.addAttribute("message", result);
		
		return "submitted-form";
	}
}
