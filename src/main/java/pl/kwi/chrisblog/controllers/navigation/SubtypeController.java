package pl.kwi.chrisblog.controllers.navigation;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubtypeController {
	
	public final static String[] SUBTYPES_SALSA = {"cubana", "la", "mambo"};
	public final static String[] SUBTYPES_BACHATA = {"social", "sensual", "dominicana"};
	public final static String[] SUBTYPES_KIZOMBA = {"social", "traditional", "urbankiz"};
	public final static String[] SUBTYPES_JAVA = {"spring"};
	
	@ModelAttribute("titles")
    public List<String> initTopics(@PathVariable(name = "title") String title) {
		
//		if (TOPIC_DANCE.equals(topic)) {
//			return Arrays.asList(SUBTYPES_DANCE);
//		} else if (TOPIC_IT.equals(topic)) {
//			return Arrays.asList(SUBTYPES_IT);
//		} else {
//			throw new IllegalArgumentException("Problem with Type");
//		}
		
		return null;
		
    }

	@RequestMapping(value="/{root}/{topic}/{type}/{subtype}")
	public String displayPage() {
		return "navigation/subtype";
	}

}