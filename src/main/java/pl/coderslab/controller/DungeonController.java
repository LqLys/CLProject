package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Answer;
import pl.coderslab.model.ArekDTO;
import pl.coderslab.model.Dungeon;
import pl.coderslab.model.DungeonDTO;
import pl.coderslab.model.Enemy;
import pl.coderslab.model.Level;
import pl.coderslab.model.Riddle;
import pl.coderslab.model.User;
import pl.coderslab.repository.DungeonRepository;
import pl.coderslab.repository.LevelRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.AnswerService;
import pl.coderslab.service.BackgroundService;
import pl.coderslab.service.EnemyService;
import pl.coderslab.service.RiddleService;
import pl.coderslab.service.UserService;

@Controller
@RequestMapping("/dungeons")
public class DungeonController {
	@Autowired
	private DungeonRepository dungeonRepository;
	
	@Autowired
	private LevelRepository levelRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EnemyService enemyService;
	
	@Autowired
	private BackgroundService backgroundService;
	
	@Autowired 
	private RiddleService riddleService;
	
	@Autowired
	private AnswerService answerService;
	
	
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
	public String generateDungeon(Model model, HttpServletRequest request) {
		DungeonDTO dungeonDto = new DungeonDTO();
				
		model.addAttribute("enemy",enemyService.generateRandomEnenmy());
		model.addAttribute("backgroundNr", backgroundService.generateRandomBackground());
				
		Riddle riddle = riddleService.generateRandomRiddle();
		model.addAttribute("answersStr", riddleService.getAnswersFromRiddle(riddle));
		
		List<Answer>ridAnswers= riddle.getAnswers();
		request.getSession().setAttribute("anz", ridAnswers);
		
			
		model.addAttribute("riddle", riddle);
				
		User user = userService.getUserFromSession(request);
		model.addAttribute("user",user);
		model.addAttribute("dungeonDTO",new DungeonDTO());
		request.getSession().setAttribute("riddle", riddle);
		request.getSession().setAttribute("dungeonDTO", dungeonDto);
				
		return "regularDungeon";

	}
	
	@RequestMapping(path="theBackEnd", method=RequestMethod.POST)
	public String processDungeon(@Valid @ModelAttribute DungeonDTO dungeonDTO, BindingResult result, Model model, HttpServletRequest request){
		List<String> dtoStrings = riddleService.getAnswersOfUser(dungeonDTO);
				
		List<Answer> anss = answerService.getAnswersFromSession(request, "anz");
		List<Answer>correctAnswers = answerService.getCorrectAnswers(anss);
				
		int numberOfCorrectAnswers = answerService.getAmountOfCorrectAnswersFromUser(anss, dtoStrings);
		
		boolean correctAnswer = answerService.evaluateAnswer(dtoStrings, numberOfCorrectAnswers);
		
		User user = userService.getUserFromSession(request);
		if(correctAnswer){
			user.setScore(user.getScore()+1);
			user.setStreak(user.getStreak()+1);
			if(user.getStreak()==3){
				user.setRafalPoints(user.getRafalPoints()+1);
				user.setStreak(0);
			}
		}else{
			user.setCurrentHealth(user.getCurrentHealth()-100);
			user.setStreak(0);
			model.addAttribute("correctStr",answerService.getTextOfCorrectAnswers(correctAnswers));
			
		}
		userRepository.save(user);
		model.addAttribute("score", user.getScore());
		model.addAttribute("remainingHP", user.getCurrentHealth());
		model.addAttribute("streak", user.getStreak());
		model.addAttribute("RafPoints", user.getRafalPoints());
		model.addAttribute("riddleResult",correctAnswer);

		if(user.getCurrentHealth()<=0){
			int finalScore = user.getScore();
			user.setCurrentHealth(user.getMaxHealth());
			if(user.getScore()>user.getHighestScore()){
				user.setHighestScore(user.getScore());
			}
			user.setScore(0);
			user.setStreak(0);
			user.setRafalPoints(0);
			
			userRepository.save(user);
			model.addAttribute("finalScore", finalScore);
			return "gameOver";
		}
			
		return "riddleResult";
		
	}
	
	
	@RequestMapping(path="/arek",method=RequestMethod.GET)
	public String tellAJoke(HttpServletRequest request, Model model){
		model.addAttribute("arekDTO", new ArekDTO());
		User user = userService.getUserFromSession(request);
		int availableRafals = user.getRafalPoints();
		int currentHealth = user.getCurrentHealth();
		model.addAttribute("availableRafals", availableRafals);
		model.addAttribute("currentHealth", currentHealth);
		 return "arekForm";
		
	}
	
	@RequestMapping(path = "/arek", method = RequestMethod.POST)
	public String addDungeon(@Valid @ModelAttribute ArekDTO arekDTO, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "arekForm";
		} else {
			User user = userService.getUserFromSession(request);
			model.addAttribute("jokeLength", arekDTO.getPointsToSpend());
			user.setCurrentHealth(user.getCurrentHealth()+arekDTO.getPointsToSpend()*100);
			user.setRafalPoints(user.getRafalPoints()-arekDTO.getPointsToSpend());
			userRepository.save(user);
			return "arekJoke";
		}
	}
	
	@RequestMapping(path="/frontEnd", method=RequestMethod.GET)
	public String visitFront(){
		return "frontDraw";
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
