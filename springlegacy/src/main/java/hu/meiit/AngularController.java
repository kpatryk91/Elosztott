package hu.meiit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AngularController {

	private List<String> availableColors = new ArrayList<String>(Arrays.asList("red", "green", "blue"));
	private Map<String, String> availableSchools = new HashMap<String, String>() {
		{
			put("HIGHSCHOOL", "Highschool");
			put("COLLEGE", "College");
			put("UNIVERSITY", "University");
		}
	};
	private List<String> availableGenders = new ArrayList<String>(Arrays.asList("MALE", "FEMALE"));

	@RequestMapping(value = "/angular")
	public ModelAndView generateAngularPageHandler() {
		return new ModelAndView("angular");
	}

	@RequestMapping(value = "/getjson", produces = "application/json")
	@ResponseBody
	public List<String> jsonRequest() {
		String[] tomb = new String[] { "alma", "korte", "fagyi" };
		return Arrays.asList(tomb);
	}

	@RequestMapping(value = "/status")
	public ModelAndView generateWebPage() {
		return new ModelAndView("angularmain");
	}

	@RequestMapping(value = "/registeruserangular", consumes = "application/json")
	@ResponseBody
	public int registerUserAngular(@RequestBody @Valid CreateUserDTO user, BindingResult result) {
		System.out.println("Username: " + user);
		if (result.hasErrors()) {
			return 0;
		}

		return 1;
	}

	@RequestMapping(value = "/getelements")
	@ResponseBody
	public Map<String, String> getElementsHandler() {
		return availableSchools;
	}
}
