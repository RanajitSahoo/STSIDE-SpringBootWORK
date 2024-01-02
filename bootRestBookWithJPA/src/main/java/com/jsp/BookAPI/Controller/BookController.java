package com.jsp.BookAPI.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.jsp.BookAPI.Dao.BookDao;
import com.jsp.BookAPI.Entities.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class BookController {
	@Autowired
	private BookDao bookdao;
	
	
	//get all books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> books = bookdao.getAllBooks();
		if(books.size()<=0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.of(Optional.of(books));
		}
	}
	
	//get a single book by id
	@GetMapping("/books/{bid}")
	public ResponseEntity<Book> getBook(@PathVariable("bid") int bid){
		Book book =null;
		try {
			book= this.bookdao.getBookById(bid);
			return ResponseEntity.status(HttpStatus.FOUND).body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> postMethodName(@RequestBody Book book) {
		Book b = null;
		try {
			b=this.bookdao.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		
	}
	
	@DeleteMapping("/books/{bid}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("bid") int id){
		try {
			this.bookdao.deleteBookById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		try {
			this.bookdao.updateBook(book, id);
			return ResponseEntity.ok().body(book);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	
	
}
