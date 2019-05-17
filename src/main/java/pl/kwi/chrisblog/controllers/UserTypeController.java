package pl.kwi.chrisblog.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class UserTypeController {
	
	private final static String[] topics = {"dance", "it"};
	
	@ModelAttribute("topics")
    public List<String> initTopics() {
        return Arrays.asList(topics);
    }

	@RequestMapping
	public String displayPage() {
		return "userType";
	}


}