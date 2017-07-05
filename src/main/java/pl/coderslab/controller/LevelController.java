package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Enemy;
import pl.coderslab.model.Level;
import pl.coderslab.model.Quote;
import pl.coderslab.repository.EnemyRepository;
import pl.coderslab.repository.LevelRepository;

@Controller
@RequestMapping("/levels")
public class LevelController {
	@Autowired
	private LevelRepository levelRepository;
	
	@Autowired
	private EnemyRepository enemyRepository;
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showLevelForm(Model model) {
		model.addAttribute("level", new Level());
		
		return "levelForm";

	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addLevel(@Valid @ModelAttribute Level level, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "levelForm";
		} else {
			levelRepository.save(level);
			return "redirect:/levels/list";
		}
	}
	
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public String showLevels(Model model){
		model.addAttribute("levels", levelRepository.findAll());
		return "levelList";
		
	}
	
	@RequestMapping(path = "/list/{id}", method = RequestMethod.GET)
	public String showLevelsOfEnemies(@PathVariable Long id, Model model) {
		List<Level> levels = levelRepository.findByEnemyId(id);
		model.addAttribute("levels", levels);
		
		return "levelList";

	}
	
	@ModelAttribute("enemies")
	public List<Enemy> getEnemies(){
		return enemyRepository.findAll();
	}
}
