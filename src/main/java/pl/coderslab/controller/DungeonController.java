package pl.coderslab.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Dungeon;
import pl.coderslab.model.Enemy;
import pl.coderslab.model.Level;
import pl.coderslab.model.User;
import pl.coderslab.repository.DungeonRepository;
import pl.coderslab.repository.EnemyRepository;
import pl.coderslab.repository.LevelRepository;
import pl.coderslab.utils.UserService;

@Controller
@RequestMapping("/dungeons")
public class DungeonController {
	@Autowired
	private DungeonRepository dungeonRepository;
	
	@Autowired
	private LevelRepository levelRepository;
	
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private EnemyRepository enemyRepository;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showDungeonForm(Model model) {
		model.addAttribute("dungeon", new Enemy());
		return "dungeonForm";

	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addDungeon(@Valid @ModelAttribute Dungeon dungeon, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "dungeonForm";
		} else {
			dungeonRepository.save(dungeon);
			return "redirect:/dungeons/list";
		}
	}
	
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public String showEnemies(Model model){
		model.addAttribute("dungeons", dungeonRepository.findAll());
		return "dungeonList";
		
	}
	
	@RequestMapping(path = "/theBackEnd", method = RequestMethod.GET)
	public String GenerateDungeon(Model model, HttpServletRequest request) {
		int nrOfEnemies = enemyRepository.getNumberOfEnemies();
		int enemyNr = new Random().nextInt(nrOfEnemies)+1;
		Enemy enemy = enemyRepository.findOne((long) enemyNr);
		model.addAttribute("enemy",enemy);
		
		
		User user = userService.getUserFromSession(request);
		model.addAttribute("user",user);
		return "regularDungeon";

	}
	
	
	@ModelAttribute("levels")
	public List<Level> getLevels(){
		return levelRepository.findAll();
		
	}
	
	@ModelAttribute("dungeons")
	public List<Dungeon> getDungeons(){
		return dungeonRepository.findAll();
		
	}
	
	
	

}
