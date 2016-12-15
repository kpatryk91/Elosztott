package hu.meiit.integration;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import hu.meiit.model.EmailDetails;

public class SendEmailActivator {

	@Autowired
	private UserDetailsService service;

	@Autowired
	private JavaMailSender mailSender;

	public @ResponsePayload ExecutionReport handleEmailSend(Message<EmailDetails> message) {
		EmailDetails details = message.getPayload();
		if (details == null) {
			return generateBadRequest("Payload?!");
		}

		String userid = details.getAddressee();
		if (userid == null) {
			return generateBadRequest("Cannot find user!");
		}

		UserDetails user = service.getUserDetails(userid);
		if (user == null) {
			return generateBadRequest("Bad user data!");
		}
		String email = user.getEmail();
		if (email == null) {
			return generateBadRequest("User data integritititititity error!");
		}
		try {
			MimeMessage Emessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(Emessage);
			helper.setTo(email);
			helper.setSubject("ILONA password recovery!");
			helper.setText("Hey!<br/><br/> userid: " + userid + "<br/><br/> Message: " + details.getMessage(), true);
			// mailSender.send(Emessage);
		} catch (Exception e) {
			generateBadRequest("Email sending failed!");
		}
		return new ExecutionReport(true, "Success!");
	}

	private ExecutionReport generateBadRequest(String cause) {
		return new ExecutionReport(false, cause);
	}
}
