package hu.meiit.integration;

import java.util.Map;

import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import hu.meiit.model.EmailDetails;

public interface SendEmailService {

	ExecutionReport sendEmail(@RequestPayload EmailDetails email, @Headers Map<String, String> headers);

	ExecutionReport sendEmail(EmailDetails email);
}
