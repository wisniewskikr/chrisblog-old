package pl.kwi.chrisblog.controllers.navigation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	
	private final static String[] TOPICS = {"dance", "it"};
	
	@ModelAttribute("topics")
    public List<String> initTopics() {
        return Arrays.asList(TOPICS);
    }

	@RequestMapping(value="/{root}")
	public String displayPage(@PathVariable(name = "root") String root) {
		return "navigation/root";
	}


}