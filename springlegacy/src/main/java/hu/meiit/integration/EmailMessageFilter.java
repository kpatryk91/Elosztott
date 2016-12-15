package hu.meiit.integration;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

import hu.meiit.model.EmailDetails;

public class EmailMessageFilter implements MessageSelector {

	public boolean accept(Message<?> message) {
		if (message.getPayload() instanceof EmailDetails) {
			EmailDetails email = (EmailDetails) message.getPayload();
			if (email.getMessage() != null) {
				if (!email.getMessage().equals("")) {
					if (email.getMessage().length() > 20) {
						return false;
					}
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}

}
