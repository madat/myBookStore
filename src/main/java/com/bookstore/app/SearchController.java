package com.bookstore.app;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.app.model.bo.Book;
import com.bookstore.app.model.dao.BookService;

@Controller
@RequestMapping("/products")
public class SearchController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
    ProductSearchValidator productSearchValidator;
	
	/**
	 * we initialize our custom validator in initBinder
	 * @param binder
	 */
	  @InitBinder  
	    private void initBinder(WebDataBinder binder) {  
	        binder.setValidator(productSearchValidator); 
	        binder.setAllowedFields("bookName");
	    }
	  
	  /**
	   * annotation a method with @ExceptionHandle, we say that this method will handles errors occurred in the application.
	   * we can say what kind of errors to handle too defining an error class
	   * 
	   * In this method, we have said that it will handle any errors of type Exception.class
	   * 
	   * this exception handler method is applicable for any errors happened for the controller methods
	   * of this class. How we can have a global error handlers? for this check out global error handler
	   * GlobalErrorHandlers.java
	   * @return
	   */
	  
	  @ExceptionHandler(Exception.class)
	  public ModelAndView handleErrors(){
		  return new ModelAndView("errorpage");
	  }
	
	@RequestMapping(value="/search")
	public ModelAndView searchForm() {
		return new ModelAndView("products/search", "product", new Book());
    }
	
	
	/**
	 * it handles the default request mapping defined in the class level
	 * @return
	 */
	@RequestMapping(value="/getProducts",method=RequestMethod.POST)
	public String processSearch(@Valid @ModelAttribute("product")Book product, BindingResult bindingResult, Model model){
		System.out.println(product.getName());
		if (bindingResult.hasErrors()) {
			return "products/search";
		}
		
		Book serchResult=bookService.getBookByName();
		 model.addAttribute("results", serchResult);
         return "products/search";
	}

}
