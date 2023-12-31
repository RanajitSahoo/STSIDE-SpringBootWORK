package com.jsp.jpa;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.jsp.jpa.Repository.UserRepository;
import com.jsp.jpa.entities.User;

@SpringBootApplication
public class MyFirstwebProject1Application {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(MyFirstwebProject1Application.class, args);
	UserRepository userRepository = context.getBean(UserRepository.class);
	
	/* todo save SingleUser*/
//	User user = new User();
//	user.setName("Ranajit");
//	user.setAge(26);
//	User save = userRepository.save(user);
//	System.out.println(save);
	
	
	/* todo save MultipleUserUser at a time*/
	
//	User user1 = new User();
//	user1.setName("Raja");
//	user1.setAge(25);
//	User user2 = new User();
//	user2.setName("Rama");
//	user2.setAge(24);
//	List<User> list = List.of(user1,user2);
//	List<User> saveAll = userRepository.saveAll(list);
//	Iterator<User> result = saveAll.iterator();
//	result.forEachRemaining(user->{
//		System.out.println(user);
//	});
	
	//update user id=52
//	Optional<User> opt = userRepository.findById(52);
//	User user = opt.get();
//	user.setName("RajaSahoo");
//	user.setAge(52);
//	User update = userRepository.save(user);
//	System.out.println(update);
//	
//	
//	
	
	
	//find all the user 
//	List<User> all = userRepository.findAll();
//	Iterator<User> itr = all.iterator();
//	itr.forEachRemaining(new Consumer<User>() {
//
//		@Override
//		public void accept(User t) {
//			System.out.println(t);
//		}
//		
//	});
	
	//delete all users
//	userRepository.deleteAll();
	
	List<User> users = userRepository.findByName("Ranajit");
	users.forEach(e->System.out.println(e));
	
	}

}
