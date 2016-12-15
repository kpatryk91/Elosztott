package hu.meiit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.meiit.integration.ExecutionReport;
import hu.meiit.integration.SendEmailService;
import hu.meiit.integration.UserDetailsService;
import hu.meiit.model.EmailDetails;
import hu.meiit.model.MessageDTO;
import hu.meiit.model.UserPassword;

@Controller
public class IntegrationController {

	@Autowired
	private SendEmailService service;

	@Autowired
	private UserDetailsService userService;

	@RequestMapping(value = "/restoreemailrequest")
	@ResponseBody
	public String restoreEmailRequestHandler(@ModelAttribute() UserPassword password) {
		System.out.println(password.toString());
		EmailDetails details = new EmailDetails(password.getUserid(), "dsadadasda", 0);
		ExecutionReport result = service.sendEmail(details);
		return result.getMessage();
	}

	@RequestMapping(value = "/sendmessage")
	@ResponseBody
	public int sendMessageHandler(@RequestBody MessageDTO message) {
		System.out.println(message.toString());
		ExecutionReport report = service.sendEmail(new EmailDetails(message.getUserid(), message.getMessage(), 1));
		if (report.isSuccess()) {
			return 1;
		} else {
			return 0;
		}
	}

	@RequestMapping(value = "/getmessages")
	@ResponseBody
	public List<String> getMessages(@RequestBody String userid) {
		System.out.println(userid);
		return userService.getMessages(userid);
	}
}
