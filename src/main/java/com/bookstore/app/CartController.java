package com.bookstore.app;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.app.model.bo.Book;
import com.bookstore.app.model.dao.BookService;

@Controller
public class CartController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	private com.bookstore.app.beans.Cart cart;
	
	@RequestMapping(value = "cart/add/{productId}")
	public String addToCart(@PathVariable("productId") Long productId, @RequestHeader("referer") String referedFrom) {
		Book product = bookService.findBookById(productId);
		cart.addProduct(product, 1);
		System.out.println("added book to cart "+product.getName());
		return "redirect:" + referedFrom;
	}
	
	@RequestMapping(value="/cart")
	public String showCart(Model model){
		model.addAttribute(cart);
		return "cart";
	}
	
	
	/**
	 * note: in case of redirect, setting attributes on model will not work.
	 * we will need to use redirectAttributes.
	 * This pattern is called redirect after post
	 * @param session
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/cart/placeOrder", method = RequestMethod.POST)
	public String placeOrder(HttpSession session, RedirectAttributes redirectAttributes) {
		if (cart.getContents().isEmpty()) {
			redirectAttributes.addFlashAttribute("cartMessage", "Cart empty. Please add products to the cart.");
			return "redirect:/cart";
		}
		else {
			//Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
			//purchaseService.savePurchase(cart.getContents(), loggedInUser);
			redirectAttributes.addFlashAttribute("cartMessage", "Order placed. Total cost: " + cart.getTotalCost());
			cart.clearCart();
			
			return "redirect:/cart";
		}
	}

}
