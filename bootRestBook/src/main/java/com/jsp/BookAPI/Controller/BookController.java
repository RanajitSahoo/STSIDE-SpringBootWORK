package com.jsp.BookAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.BookAPI.model.Book;
import com.jsp.BookAPI.services.BookServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class BookController {
	@Autowired
	private BookServices bookService;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookService.getAllBooks();
	}

	@GetMapping("/books/{id}")
	public Book getMethodName(@PathVariable("id") int id) {
		return this.bookService.getBookById(id);
	}

	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {

		return this.bookService.addBook(book);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		 this.bookService.deleteBook(id);
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable("id") int id,@RequestBody Book book) {
		
		
		 this.bookService.updateBook(book, id);
		 return book;
	}

}
