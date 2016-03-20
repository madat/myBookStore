package com.bookstore.app;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bookstore.app.model.bo.Book;

@Controller
public class ProductSearchValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Book.class.isAssignableFrom(cls); 
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Book book=(Book)obj;
		System.out.println("book name="+book.getName());
		if(book.getName()==null||book.getName().length()<3){
			errors.rejectValue("bookName", "required", "Book Name should be atleast of three characters");
		}
		
	}

}
