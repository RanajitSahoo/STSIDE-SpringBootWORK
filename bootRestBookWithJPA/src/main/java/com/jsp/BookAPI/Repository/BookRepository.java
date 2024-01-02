package com.jsp.BookAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.BookAPI.Entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
