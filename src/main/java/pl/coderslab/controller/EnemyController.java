package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Enemy;
import pl.coderslab.repository.EnemyRepository;

@Controller
@RequestMapping("/enemies")
public class EnemyController {
	@Autowired
	private EnemyRepository enemyRepository; 
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showEnemyForm(Model model) {
		model.addAttribute("enemy", new Enemy());
		return "enemyForm";

	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addEnemy(@Valid @ModelAttribute Enemy enemy, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "enemyForm";
		} else {
			enemyRepository.save(enemy);
			return "redirect:/enemies/list";
		}
	}
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public String showEnemies(Model model){
		model.addAttribute("enemies", enemyRepository.findAll());
		return "enemyList";
		
	}
}
