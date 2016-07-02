package com.bookstore.app;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.app.model.bo.Book;
import com.bookstore.app.model.bo.HomePageInfo;
import com.bookstore.app.model.dao.BookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BookService bookService;
	
	/**
	 * we can bind a object as ModelAttribute, making it available for any requests.
	 * This will be called before serving any requestmapping and bind it to model  object explicitly.
	 * 
	 * @return
	 */
	@ModelAttribute("homePage")
	public HomePageInfo getModelAttributeOfHomePageInfo(){
		HomePageInfo homePage=new HomePageInfo();
		homePage.setDiscountInfo("Diwali Discount on all Books");
		return homePage;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		
		List<Book> featuredProducts = bookService.getAllBooks();
		
		logger.info("allbooks===",featuredProducts);
		
		//model.addAttribute("welcome", "Welocme to mY book Store" );
		model.addAttribute("featuredProducts", featuredProducts);
		
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/allbooks.hml", method = RequestMethod.GET)
	public ModelAndView home(Locale locale) {
		System.out.println("in ModelAndView");
		
		ModelAndView modelView=new ModelAndView("showbooks");
   	    modelView.addObject("msg","Congrats, you are registered.");
   	    modelView.addObject("allBooks",bookService.getAllBooks());
   	    modelView.addObject("lists", getList());
        return modelView;
	}
	
	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}

	
	
}
