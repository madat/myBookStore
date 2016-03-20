package com.bookstore.app;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.app.model.bo.Customer;
import com.bookstore.app.model.dao.CustomerService;


@Controller
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	CustomerService custService;
	
	@RequestMapping(params = "register")
	public String createForm(Model model) {
		model.addAttribute("user", new Customer());
		return "users/register";
	}
	
	/**
	 * this controller method will save the user and
	 * after that it will do a url redirect . So the controller will call getUserProfile method
	 * that handles the redirected url pattern
	 * @param customer
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Valid Customer user,BindingResult result) {
		System.out.println("validation errors="+result.hasErrors());
		if(result.hasErrors()){
			System.out.println("binding result has errors###########");
			return "users/register";
		}
		custService.saveUser(user);
		//ModelAndView modelView=new ModelAndView("users/registration_success");
		//modelView.addObject("userName", user.getName());
		String name=user.getName();
		return "redirect:/users/"+name;
	}
	
	/**
	 * the spring framework sends a model object when we send a request to a controller method. We can read and write 
	 * on the model object and exchange data
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{userId}")
	public String getUserProfile(@PathVariable String userId,Map<String,Object> model){
		Customer cust=custService.getUser(userId);
		model.put("user",cust);
		return "users/profileView";
	}
}
