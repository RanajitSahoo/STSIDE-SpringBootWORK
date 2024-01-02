package com.jsp.BookAPI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jsp.BookAPI.model.Book;
@Component
public class BookServices {
	private static List<Book> list=new ArrayList<Book>();
	static {
		list.add(new Book(1,"java sah","Ranajit"));
		list.add(new Book(2,"python","Raja"));
		list.add(new Book(3,"Sql","Tanu"));
	}
	
	//get All books
	public List<Book> getAllBooks(){
		return list;
	}
	
	//get single book
	
	public Book getBookById(int id) {
		Book b = list.stream().filter(e->e.getId()==id).findFirst().get();
		
		return b;
	}
	// adding the book
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}
//	public Book deleteBook(int id) {
//		Book book = list.stream().filter(e->e.getId()==id).findFirst().get();
//		list.remove(book);
//		return book;
//	}
	
	public void deleteBook(int bid) {
		list=list.stream().filter(book->{
			if(book.getId()!=bid)return true;
			else return false;
		}).collect(Collectors.toList());
	}
	
	public void updateBook(Book book,int id) {
		list =list.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
