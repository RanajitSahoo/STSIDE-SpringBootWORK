package com.jsp.BookAPI.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.BookAPI.Entities.Book;
import com.jsp.BookAPI.Repository.BookRepository;
@Component
public class BookDao {
	@Autowired
	private BookRepository bookRepository;
	
	//get All Book
	public List<Book> getAllBooks(){
		List<Book> all = this.bookRepository.findAll();
		return all;
	}
	
	//get a single book by id
	public Book getBookById(int id) {
		Optional<Book> opt = this.bookRepository.findById(id);
		Book book = opt.get();
		return book;
	}
	
	//add a new Book 
	public Book addBook(Book b) {
		Book book = this.bookRepository.save(b);
		return book;
	}
	
	//delete a book by id
	public void deleteBookById(int id) {
		this.bookRepository.deleteById(id);
	}
	
	public Book updateBook(Book book,int id) {
		book.setId(id);
		Book book1 = this.bookRepository.save(book);
		return book1;
	}

}
