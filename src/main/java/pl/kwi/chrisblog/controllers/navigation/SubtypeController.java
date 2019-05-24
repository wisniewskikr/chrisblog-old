package pl.kwi.chrisblog.controllers.navigation;

import java.lang.reflect.Field;
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
	public final static String[] SUBTYPES_KIZOMBA = {"socialkizz", "traditional", "urbankiz"};
	public final static String[] SUBTYPES_JAVA = {"spring"};
	
	@ModelAttribute("titles")
    public List<String> initTitles(@PathVariable(name = "subtype") String subtype) {
		return Arrays.asList(getTitles(subtype));
    }

	@RequestMapping(value="/{root}/{topic}/{type}/{subtype}")
	public String displayPage() {
		return "navigation/subtype";
	}
	
	private String[] getTitles(String subtype) {
		
		try {			
			String arrayName = ("TITLES_" + subtype).toUpperCase();
			Field field = TitleController.class.getField(arrayName);
			return (String[])field.get(null);					
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}