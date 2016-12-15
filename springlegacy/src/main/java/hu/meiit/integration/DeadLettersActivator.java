package hu.meiit.integration;

import org.springframework.messaging.Message;

import hu.meiit.model.EmailDetails;

public class DeadLettersActivator {

	public ExecutionReport sendFilteredEmailReport(Message<EmailDetails> message) {
		ExecutionReport report = new ExecutionReport(false, "Invalid message format!");
		
		return report;
	}
}
