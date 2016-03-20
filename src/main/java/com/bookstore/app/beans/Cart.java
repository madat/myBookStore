package com.bookstore.app.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.bookstore.app.model.bo.Book;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, 
      proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
	



	private Map<Book, Integer> contents = new HashMap<Book, Integer>();

	public Map<Book, Integer> getContents() {
		return contents;
	}
	
	public Set<Book> getProducts() {
		return contents.keySet();
	}
	
	public void addProduct(Book product, int count) {
		
		if (contents.containsKey(product)) {
			contents.put(product, contents.get(product) + count);
		} 
		else {
			contents.put(product, count);
		}
	}
	
	
	public void removeProduct(Book product) {
		contents.remove(product);
	}
	
	public void clearCart() {
		contents.clear();
	}
	
	@Override
	public String toString() {
		return contents.toString();
	}
	
	public double getTotalCost() {
		double totalCost = 0;
		for (Book product : contents.keySet()) {
			totalCost += product.getPrice();
		}
		return totalCost;
	}
	


}
