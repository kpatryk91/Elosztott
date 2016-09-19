package hu.meiit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexHandler {

	@RequestMapping(value = "/")
	@ResponseBody
	public String indexPage() {
		return "Ez már tényleg egy saját szöveg amit ki kell írnia tövábbi felesleges betû 1 2 3!";
	}
}
