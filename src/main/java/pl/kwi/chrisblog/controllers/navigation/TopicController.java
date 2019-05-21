package pl.kwi.chrisblog.controllers.navigation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopicController {
	
	public final static String[] TOPICS = {"dance", "it"};
	
	@ModelAttribute("types")
    public List<String> initTopics(@PathVariable(name = "topic") String topic) {		
		return Arrays.asList(getTypes(topic));	
    }

	@RequestMapping(value="/{root}/{topic}")
	public String displayPage() {
		return "navigation/topic";
	}
	
	private String[] getTypes(String topic) {
		
		try {
			for (String topicFromArray : TOPICS) {
				if (topic.equals(topicFromArray)) {
					String arrayName = ("TYPES_" + topicFromArray).toUpperCase();
					Field field = TypeController.class.getField(arrayName);
					return (String[])field.get(null);					
				}
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
 
}