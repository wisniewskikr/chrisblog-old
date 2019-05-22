package pl.kwi.chrisblog.controllers.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TitleController {
	
	public final static String[] TITLES_CUBANA = {"1", "2", "3"};
	public final static String[] TITLES_LA = {"1", "2", "3"};
	public final static String[] TITLES_MAMBO = {"1", "2", "3"};
	
	public final static String[] TITLES_SOCIAL = {"1", "2", "3"};
	public final static String[] TITLES_SENSUAL = {"1", "2", "3"};
	public final static String[] TITLES_DOMINICANA = {"1", "2", "3"};
	
	public final static String[] TITLES_SOCIALKIZZ = {"1", "2", "3"};
	public final static String[] TITLES_TRADITIONAL = {"1", "2", "3"};
	public final static String[] TITLES_URBANKIZZ = {"1", "2", "3"};
	
	public final static String[] TITLES_SPRING = {"1", "2", "3"};
	
	
	@ModelAttribute("title")
    public String initTopics(@PathVariable(name = "title") String title) {
		return title;		
    }

	@RequestMapping(value="/{root}/{topic}/{type}/{subtype}/{title}")
	public String displayPage() {
		return "navigation/title";
	}
	

}