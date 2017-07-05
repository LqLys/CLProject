package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Answer;
import pl.coderslab.model.Riddle;
import pl.coderslab.repository.AnswerRepository;
import pl.coderslab.repository.RiddleRepository;

@Controller
@RequestMapping("/answers")
public class AnswerController {
	@Autowired
	private AnswerRepository answerRepository; 
	
	@Autowired
	private RiddleRepository riddleRepository;
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showAnswerForm(Model model) {
		model.addAttribute("answer", new Answer());
		return "answerForm";

	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addAnswer(@Valid @ModelAttribute Answer answer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "answerForm";
		} else {
			answerRepository.save(answer);
			return "redirect:/answers/list";
		}
	}
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public String showAnswers(Model model){
		model.addAttribute("answers", answerRepository.findAll());
		return "answerList";
		
	}
	
	@ModelAttribute("riddles")
	public List<Riddle> getRiddles(){
		return riddleRepository.findAll();
	}

}
