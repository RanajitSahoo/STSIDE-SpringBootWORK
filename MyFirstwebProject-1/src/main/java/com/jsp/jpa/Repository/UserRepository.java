package com.jsp.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
