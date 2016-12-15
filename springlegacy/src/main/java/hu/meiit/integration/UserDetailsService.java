package hu.meiit.integration;

import java.util.Collection;
import java.util.List;

public interface UserDetailsService {

	UserDetails getUserDetails(String userid);
	
	Collection<UserDetails> getUsers();
	
	boolean sendMessage(String userid, String message);
	
	List<String> getMessages(String userid);
}
