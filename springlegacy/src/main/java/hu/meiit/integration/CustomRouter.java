package hu.meiit.integration;

import hu.meiit.model.EmailDetails;

public class CustomRouter {

	public String routeDecision(EmailDetails email) {
		if (email.getType() == 0) {
			return "sendEmailChannel";
		} else {
			return "sendMessageChannel";
		}
	}
}
