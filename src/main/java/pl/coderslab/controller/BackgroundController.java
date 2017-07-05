package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Background;
import pl.coderslab.model.Enemy;
import pl.coderslab.repository.BackgroundRepository;

@Controller
@RequestMapping("/backgrounds")
public class BackgroundController {
	
	@Autowired
	private BackgroundRepository backgroundRepository; 
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showBackgroundForm(Model model) {
		model.addAttribute("background", new Background());
		return "backgroundForm";

	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addBackground(@Valid @ModelAttribute Background background, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "backgroundForm";
		} else {
			backgroundRepository.save(background);
			return "redirect:/backgrounds/list";
		}
	}
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public String showBackgrounds(Model model){
		model.addAttribute("backgrounds", backgroundRepository.findAll());
		return "backgroundList";
		
	}

}
