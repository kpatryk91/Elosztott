package hu.meiit.integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import hu.meiit.model.EmailDetails;

public class EmailMessageEnrichter {

	public static final String MESSAGE_TYPE = "EMAIL_MESSAGE_TYPE";

	public Message<EmailDetails> enrichtEmailMessage(Message<EmailDetails> message) {

		int type = 0;
		if (message.getPayload().getType() == 1) {
			type = 1;
		}
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put(MESSAGE_TYPE, type);
		MessageHeaders header = new MessageHeaders(headers);
		Message<EmailDetails> updatedMessage = MessageBuilder.createMessage(message.getPayload(), header);
		return updatedMessage;
	}
}
