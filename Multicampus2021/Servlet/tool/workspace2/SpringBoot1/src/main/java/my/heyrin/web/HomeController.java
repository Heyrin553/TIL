package my.heyrin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@ResponseBody
	@RequestMapping("/home.heyrin")
	public String home() {
		System.out.println("Hello heyrin");
		return "Hello 혜린";
	}

}
