package hu.meiit.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserServiceEndpoint {

	@Autowired
	private UserDetailsService service;

	public @ResponsePayload UserDetails getUser(String userid) {
		return service.getUserDetails(userid);
	}

}
