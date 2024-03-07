package com.SpringSecurity.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.SpringSecurity.Model.User;

@Service
public class UserService {
	private List<User> store = new ArrayList<>();

	public UserService() {
		store.add(new User(UUID.randomUUID().toString(),"Vivek","vivek@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Motu","motu@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Ashish","ashish@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"chotu","chotu@gmail.com"));
	}

	public List<User> getUsers() {
		
		return this.store;

	}
}
