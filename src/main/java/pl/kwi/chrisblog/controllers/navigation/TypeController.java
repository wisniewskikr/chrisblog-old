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
public class TypeController extends AbstrController {
	
	public final static String[] TYPES_DANCE = {"salsa", "bachata", "kizomba"};
	public final static String[] TYPES_IT = {"java"};
	
	@ModelAttribute("subtypes")
    public List<String> initSubtypes(@PathVariable(name = "type") String type) {
		return Arrays.asList(getSubtypes(type));	
    }

	@RequestMapping(value="/{topic}/{type}")
	public String displayPage() {
		return "navigation/type";
	}
	
	private String[] getSubtypes(String type) {
		
		try {			
			String arrayName = ("SUBTYPES_" + type).toUpperCase();
			Field field = SubtypeController.class.getField(arrayName);
			return (String[])field.get(null);					
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	

}