package pl.coderslab.controller;

import java.util.ArrayList;
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

import pl.coderslab.model.Answer;
import pl.coderslab.model.ArekDTO;
import pl.coderslab.model.Dungeon;
import pl.coderslab.model.DungeonDTO;
import pl.coderslab.model.Enemy;
import pl.coderslab.model.Level;
import pl.coderslab.model.Riddle;
import pl.coderslab.model.User;
import pl.coderslab.repository.BackgroundRepository;
import pl.coderslab.repository.DungeonRepository;
import pl.coderslab.repository.EnemyRepository;
import pl.coderslab.repository.LevelRepository;
import pl.coderslab.repository.RiddleRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.utils.UserService;

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
	private EnemyRepository enemyRepository;
	
	@Autowired
	private BackgroundRepository backgroundRepository;
	
	@Autowired
	private RiddleRepository riddleRepository;
	
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
	//TU SIE DZIEJE MAGIA
	@RequestMapping(path = "/theBackEnd", method = RequestMethod.GET)
	public String generateDungeon(Model model, HttpServletRequest request) {
		DungeonDTO dungeonDto = new DungeonDTO();
								
		int nrOfEnemies = enemyRepository.getNumberOfEnemies();
		int enemyNr = new Random().nextInt(nrOfEnemies)+1;
		Enemy enemy = enemyRepository.findOne((long) enemyNr);
		model.addAttribute("enemy",enemy);
		
		int nrOfBackgrounds = backgroundRepository.getNumberOfBackgrounds();
		int backgroundNr = new Random().nextInt(nrOfBackgrounds)+1;
		model.addAttribute("backgroundNr", backgroundNr);
		
		int nrOfRiddles = riddleRepository.getNumberOfRiddles();
		int riddleNr = new Random().nextInt(nrOfRiddles)+1;
		Riddle riddle = riddleRepository.findOne((long) riddleNr);
		
		List<String>answersStr = new ArrayList<>();
		for(Answer a : riddle.getAnswers()){
			answersStr.add(a.getText());
		}
		model.addAttribute("answersStr", answersStr);
		
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
		DungeonDTO dung = (DungeonDTO) request.getSession().getAttribute("dungeonDTO");
		String ans = "";
		List<String> dtoStrings = dungeonDTO.getAnswersStr();
		for(String s : dtoStrings){
			ans+= s + " ";
		}
		//ile poprawnych odpowiedzi ogolnie
		List<Answer> anss = (List<Answer>) request.getSession().getAttribute("anz");
		List<Answer>correctAnswers = new ArrayList<>();
		String boo = "";
		int cor = 0;
		int incorr = 0;
		for(Answer a : anss){
			boo += a.isCorrect() + " ";
			if(a.isCorrect()){
				correctAnswers.add(a);
				cor++;
			}else{
				incorr++;
			}
		}
		String correctStr = "";
		
		for(Answer a : correctAnswers){
			correctStr += a.getText() + " ";
		}
		
		//ile poprawnych odpowiedzi od uzytkownika
		int corrFromForm = 0;
		for(Answer a : anss){
			for(String s : dtoStrings){
				if(a.getText().equals(s) && a.isCorrect()){
					corrFromForm++;
				}
			}
		}
		
		boolean correctAnswer = dtoStrings.size() == corrFromForm ? true : false;
		int userWrong = anss.size()-corrFromForm;
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
			model.addAttribute("correctStr",correctStr);
			
		}
		userRepository.save(user);
		model.addAttribute("score", user.getScore());
		model.addAttribute("remainingHP", user.getCurrentHealth());
		model.addAttribute("streak", user.getStreak());
		model.addAttribute("RafPoints", user.getRafalPoints());
		model.addAttribute("riddleResult",correctAnswer);
//		return "wartosci odpowiedzi ogolnie: " + boo + "<br>" + "odpowiedzi uzytkownika: " + ans +"<br> " +
//				"ilosc poprawnych odpowiedzi ogolnie: " + cor + "<br>" +"ilosc zlych odpowiedzi ogolnie: " +
//				incorr + "<br>" + "ilosc poprawnych odpowiedzi od uzytkownika: " +corrFromForm  +"<br>" + "ilosc niezaznaczonych odp: " + userWrong +
//				"<br>" + "ile odpowiedzi zaznaczyl user: " + dtoStrings.size() + "<br>" + "odpowiedz jest: " + correctAnswer;
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
