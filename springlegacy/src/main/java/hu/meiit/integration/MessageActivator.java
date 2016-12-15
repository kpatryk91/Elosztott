package hu.meiit.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import hu.meiit.model.EmailDetails;

public class MessageActivator {

	@Autowired
	private UserDetailsService service;
	
	public @ResponsePayload ExecutionReport activate(Message<EmailDetails> message) {
		
		EmailDetails email = message.getPayload();
		if(email == null) {
			return generateErrorResult("User not found!");
		}
		service.sendMessage(email.getAddressee(), email.getMessage());
		return new ExecutionReport(true, "Success!");
	}
	
	private ExecutionReport generateErrorResult(String error) {
		return new ExecutionReport(false, error);
	}
}
