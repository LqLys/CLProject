package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Riddle;
import pl.coderslab.repository.RiddleRepository;
@Controller
@RequestMapping("/riddles")
public class RiddleController {
	
	@Autowired
	private RiddleRepository riddleRepository; 
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showRiddleForm(Model model) {
		model.addAttribute("riddle", new Riddle());
		return "riddleForm";

	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addRiddle(@Valid @ModelAttribute Riddle riddle, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "riddleForm";
		} else {
			riddleRepository.save(riddle);
			return "redirect:/riddles/list";
		}
	}
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public String showRiddles(Model model){
		model.addAttribute("riddles", riddleRepository.findAll());
		return "riddleList";
		
	}

}
