package pl.kwi.chrisblog.controllers.navigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PropertySource("classpath:titles/titles_cubana.properties")
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
	
	@Autowired
	private Environment env;	
	
	@ModelAttribute("title")
    public String initTitle(@PathVariable(name = "title") String title) {		
		return env.getProperty(title  + ".title");
    }
	
	@ModelAttribute("description")
    public String initDescription(@PathVariable(name = "title") String title) {		
		return env.getProperty(title  + ".description");
    }

	@RequestMapping(value="/{root}/{topic}/{type}/{subtype}/{title}")
	public String displayPage() {
		return "navigation/title";
	}
	

}