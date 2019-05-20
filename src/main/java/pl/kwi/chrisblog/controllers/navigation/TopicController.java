package pl.kwi.chrisblog.controllers.navigation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopicController {
	
	private final static String TOPIC_DANCE = "dance";
	private final static String TOPIC_IT = "it";
	private final static String[] TYPES_DANCE = {"salsa", "bachata", "kizomba"};
	private final static String[] TYPES_IT = {"java"};
	
	@ModelAttribute("types")
    public List<String> initTopics(@PathVariable(name = "topic") String topic) {
		
		if (TOPIC_DANCE.equals(topic)) {
			return Arrays.asList(TYPES_DANCE);
		} else if (TOPIC_IT.equals(topic)) {
			return Arrays.asList(TYPES_IT);
		} else {
			throw new IllegalArgumentException("Problem with Topic");
		}
		
    }

	@RequestMapping(value="/{root}/{topic}")
	public String displayPage() {
		return "navigation/topic";
	}

}