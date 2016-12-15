package hu.meiit.integration;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service(value = "UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private Map<String, UserDetails> users = new HashMap<String, UserDetails>();

	public UserDetailsServiceImpl() {
		users.put("bela", new UserDetails("bela", "kpatryk91@gmail.com", "detail", null));
		users.put("patrik", new UserDetails("patrik", "kpatryk91@gmail.com", "detail", null));
		for (int i = 0; i < 10; i++) {
			String userid = "User" + Math.round(Math.random() * 10000);
			users.put(userid, new UserDetails(userid, userid + "@gmail.com", userid + "details", null));
		}
	}

	public UserDetails getUserDetails(String userid) {
		return users.get(userid);
	}

	public Collection<UserDetails> getUsers() {
		return users.values();
	}

	public List<String> getMessages(String userid) {
		UserDetails user = users.get(userid);
		if(user == null) {
			return null;
		}
		return user.getMessages();
	}

	public boolean sendMessage(String userid, String message) {
		UserDetails user = users.get(userid);
		if (user == null) {
			return false;
		}
		user.setMessages(message);
		return true;

	}

}
