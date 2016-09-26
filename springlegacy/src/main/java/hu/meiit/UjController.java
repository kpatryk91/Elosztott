package hu.meiit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.meiit.service.UserManager;

@Controller
@RequestMapping(value = "/admin")
public class UjController {

	@Autowired
	private UserManager userManager;
	
	@RequestMapping(value = "/status")
	public ModelAndView generateStatusPage() {
		ModelAndView mav = new ModelAndView("status");
		mav.addObject("users", userManager.getUsers());
		return mav;
	}

	@RequestMapping(value = "/get-balance")
	public ModelAndView generateBalancePage() {
		ModelAndView mav = new ModelAndView("balance");

		return mav;
	}

	@RequestMapping(value = "/newuser", method = { RequestMethod.GET })
	public ModelAndView generateNewUserPage() {
		ModelAndView mav = new ModelAndView("newuser");

		return mav;
	}
	
	@RequestMapping(value = "/newuser", method = { RequestMethod.POST })
	public ModelAndView generateCreateUserHandler(@ModelAttribute() CreateUserDTO dto) {
		ModelAndView mav = new ModelAndView("newuser");
		
		if(dto.getUsername() != null && !dto.getUsername().equals("") ) {
			userManager.storeUser(dto);
			mav.setViewName("redirect:/admin/status");
			return mav;
		}		
		System.out.print("Username: " + dto.getUsername());
		System.out.print("Username: " + dto.getCredit());
		mav.addObject("status", "error!");
		return mav;
	}
}
