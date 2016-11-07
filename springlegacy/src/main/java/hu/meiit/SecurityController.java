package hu.meiit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

	@RequestMapping(value = "/logina", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView generateoginPageAndError() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/loginprocedura", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView loginproc() {
		return new ModelAndView("login");
	}
}
