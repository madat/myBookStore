package com.bookstore.app;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.app.model.dao.CustomerService;

@Controller
public class LoginController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView login=new ModelAndView("login");
		
		return login;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String verifyLogin(@RequestParam String userName,@RequestParam String pswd,Model model,HttpSession session){
		boolean isValid=customerService.isValidLogin(userName, pswd);
		if(!isValid){
			model.addAttribute("loginError", "Error login.Please try again");
			return "login";
		}
		session.setAttribute("loginUser", userName);
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "login";
	}

}
