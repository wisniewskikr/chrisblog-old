package pl.kwi.chrisblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class IndexController {

	@RequestMapping
	public String index() {
		return "redirect:home";
	}
	
}