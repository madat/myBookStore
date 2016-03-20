package com.bookstore.app.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookstore.app.model.bo.Book;

@Component
public class BookService {
	
	public List<Book> getAllBooks(){
		
		List<Book> books=new ArrayList();
		
		Book book1=new Book(1,"Book1","Author1");
		Book book2=new Book(2,"Book2","Author2");
		Book book3=new Book(3,"Book3","Author3");
		Book book4=new Book(4,"Book4","Author4");
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		
		return books;
	}
	
	public Book getBookByName(){
		return new Book(1,"Book1","Author1");
	}
	
	public Book findBookById(Long productId){
		if(productId==1){
			return  new Book(1,"Book1","Author1");
		}else if(productId==2){
			return new Book(2,"Book2","Author2");
		}else if(productId==3){
			return new Book(3,"Book3","Author3");
		}else{
			return new Book(4,"Book4","Author4");
		}
	}

}
