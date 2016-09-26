package hu.meiit.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import hu.meiit.CreateUserDTO;
import hu.meiit.model.User;

public class UserManager {

	private Map<String, User> users = new HashMap<String, User>();
	
	private Object storeUserToken = new Object();
	
	public void storeUser(CreateUserDTO user) {
		synchronized (storeUserToken) {
			User userStore = new User();
			userStore.setUsername(user.getUsername());
			userStore.setCredit(user.getCredit());
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
}
