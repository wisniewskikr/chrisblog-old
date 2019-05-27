package pl.kwi.chrisblog.controllers.navigation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kwi.chrisblog.controllers.AbstrController;

@Controller
public class RootController extends AbstrController {
	
		
	@ModelAttribute("topics")
    public List<String> initTopics() {
        return Arrays.asList(TopicController.TOPICS);
    }

	@RequestMapping
	public String displayPage() {
		return "navigation/root";
	}


}