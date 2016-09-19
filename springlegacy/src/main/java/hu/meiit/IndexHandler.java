package hu.meiit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexHandler {

	@RequestMapping(value = "/")
	@ResponseBody
	public String indexPage() {
		return "Ez m�r t�nyleg egy saj�t sz�veg amit ki kell �rnia t�v�bbi felesleges bet� 1 2 3!";
	}
}
