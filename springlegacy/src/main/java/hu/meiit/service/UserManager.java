package hu.meiit.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import hu.meiit.CreateUserDTO;
import hu.meiit.model.NEM;
import hu.meiit.model.School;
import hu.meiit.model.User;

public class UserManager implements UserDetailsService{

	private Map<String, User> users = new HashMap<String, User>();

	private Object storeUserToken = new Object();

	public UserManager() {
		users = new HashMap<String, User>();
		for (CreateUserDTO user : generateFakeUsers()) {
			storeUser(user);
		}
	}

	public void storeUser(CreateUserDTO user) {
		synchronized (storeUserToken) {
			User userStore = new User();
			userStore.setUsername(user.getUsername());
			userStore.setCredit(user.getCredit());
			userStore.setGend(user.getGend().name());
			userStore.setSchool(user.getSchool().name());
			List<String> colors = new ArrayList<String>();
			for (String color : user.getFavcol()) {
				colors.add(color);
			}
			userStore.setFavcols(colors);
			users.put(userStore.getUsername(), userStore);
		}
	}

	public User getUserByName(String name) {
		synchronized (storeUserToken) {
			return users.get(name);
		}
	}

	public Collection<User> getUsers() {
		synchronized (storeUserToken) {
			return users.values();
		}
	}

	public boolean deleteuser(String userid) {
		User result = users.remove(userid);
		if (result == null) {
			return false;
		} else {
			return true;
		}
	}

	public List<CreateUserDTO> generateFakeUsers() {
		int number = 5;
		List<CreateUserDTO> users = new ArrayList<CreateUserDTO>(number);
		CreateUserDTO user = null;
		for (int i = 0; i < number; i++) {
			user = new CreateUserDTO("Name" + (Math.random() * 10), Long.toString(Math.round(Math.random() * 10)));
			if (Math.random() > 0.5) {
				user.setGend(NEM.MALE);
				user.setSchool(School.HIGHSCHOOL);
				List<String> colors = new ArrayList<String>();
				colors.add("red");
				colors.add("green");
				user.setFavcol(colors);
			} else {
				user.setGend(NEM.FEMALE);
				user.setSchool(School.UNIVERSITY);
				List<String> colors = new ArrayList<String>();
				colors.add("blue");
				user.setFavcol(colors);
			}
			users.add(user);
		}
		List<String> colors = new ArrayList<String>();
		colors.add("red");
		colors.add("green");
		user.setFavcol(colors);
		
		CreateUserDTO u = new CreateUserDTO();
		u.setGend(NEM.MALE);
		u.setSchool(School.HIGHSCHOOL);
		u.setFavcol(colors);
		u.setUsername("bela");
		u.setCredit("42");
		users.add(u);
		return users;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return users.get(username);
	}
}
