package com.bookstore.app.model.bo;


public class Book {
	
	private String name;
    private String author;
    private int price=10;
    private int id;
    
    public Book(int id,String bookName,String author){
    	this.name=bookName;
    	this.author=author;
    	this.id=id;
    }
	
    public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String bookName) {
		this.name = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
