package com.jsp.BookAPIOTO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.BookAPIOTO.DTO.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
