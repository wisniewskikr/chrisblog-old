package pl.kwi.chrisblog.controllers.navigation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kwi.chrisblog.controllers.AbstrController;

@Controller
public class TopicController extends AbstrController {
	
	public final static String[] TOPICS = {"dance", "it"};
	
	@ModelAttribute("types")
    public List<String> initTypes(@PathVariable(name = "topic") String topic) {		
		return Arrays.asList(getTypes(topic));	
    }

	@RequestMapping(value="/{topic}")
	public String displayPage() {
		return "navigation/topic";
	}
	
	private String[] getTypes(String topic) {
		
		try {			
			String arrayName = ("TYPES_" + topic).toUpperCase();
			Field field = TypeController.class.getField(arrayName);
			return (String[])field.get(null);					
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
 
}