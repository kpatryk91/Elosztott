package hu.meiit;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.meiit.model.NEM;
import hu.meiit.model.UserModelData;
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
		UserModelData data = new UserModelData();
		data.setUsername("");
		data.setCredit("");
		data.getSchool().put("HIGHSCHOOL", "Highschool");
		Map<String, String> selected = new HashMap<String, String>();
		selected.put("HIGHSCHOOL", "Highschool");
		selected.put("COLLEGE", "College");
		selected.put("UNIVERSITY", "University");
		mav.addObject("pageData", data);
		mav.addObject("schools", selected);
		return mav;
	}

	@RequestMapping(value = "/newuser", method = { RequestMethod.POST })
	public ModelAndView generateCreateUserHandler(@Valid @ModelAttribute() CreateUserDTO dto, BindingResult result) {

		ModelAndView mav = new ModelAndView("newuser");
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				if (error.getObjectName().equals("username")) {

				}
			}
		}

		UserModelData data = new UserModelData();
		data.setUsername(dto.getUsername());
		data.setCredit(dto.getCredit());
		data.getSchool().put("HIGHSCHOOL", "Highschool");
		Map<String, String> selected = new HashMap<String, String>();
		selected.put("HIGHSCHOOL", "Highschool");
		selected.put("COLLEGE", "College");
		selected.put("UNIVERSITY", "University");
		mav.addObject("pageData", data);
		mav.addObject("schools", selected);
		System.out.println(dto.getFavcol());

		boolean hasError = false;
		if (dto.getUsername() == null || dto.getUsername().equals("")) {
			mav.addObject("username", "");
			hasError = true;
		} else {
			mav.addObject("username", dto.getUsername());
		}

		try {
			Integer.parseInt(dto.getCredit());

			mav.addObject("credit", dto.getCredit());
		} catch (Exception e) {
			hasError = true;
			mav.addObject("credit", "");
		}

		switch (dto.getSchool()) {
		case COLLEGE:
			mav.addObject("COLLEGE", "selected='selected'");
			break;
		case HIGHSCHOOL:
			mav.addObject("HIGHSCHOOL", "selected='selected'");
			break;
		case UNIVERSITY:
			mav.addObject("UNIVERSITY", "selected='selected'");
		}

		if (dto.getFavcol() != null) {
			for (String elem : dto.getFavcol()) {
				if (elem.equals("red")) {
					mav.addObject("RED", "checked='checked'");
				}

				if (elem.equals("green")) {
					mav.addObject("GREEN", "checked='checked'");
				}

				if (elem.equals("blue")) {
					mav.addObject("BLUE", "checked='checked'");
				}
			}
		}

		if (dto.getGender() == NEM.MALE) {
			mav.addObject("male", "checked='checked'");
		} else {
			mav.addObject("female", "checked='checked'");
		}

		if (hasError == true) {
			mav.addObject("status", "error!");
			return mav;
		}
		userManager.storeUser(dto);

		mav.setViewName("redirect:/admin/status");
		return mav;
	}
	
	private UserModelData generateDefaultModelData() {
		UserModelData data = new UserModelData();
		data.setUsername("");
		data.setCredit("");
		data.getSchool().put("HIGHSCHOOL", "Highschool");
		
		return data;
	}
}
