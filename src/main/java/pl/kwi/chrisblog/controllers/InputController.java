package pl.kwi.chrisblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.chrisblog.commands.InputCommand;
import pl.kwi.chrisblog.services.NameService;

@Controller
@RequestMapping(value="/input")
public class InputController {
	
	@Autowired
	private NameService nameService;

	@RequestMapping
	public String displayPage() {
		return "input";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(@ModelAttribute("command")InputCommand command) {
		nameService.save(command.getName());
		return "redirect:/output";
	}

}