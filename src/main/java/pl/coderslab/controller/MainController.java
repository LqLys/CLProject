package pl.coderslab.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.model.Shout;
import pl.coderslab.model.User;
import pl.coderslab.repository.ShoutRepository;
import pl.coderslab.repository.UserRepository;



@Controller 
@RequestMapping("/")
public class MainController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ShoutRepository shoutRepository;
	
	@RequestMapping(method= RequestMethod.GET)
	public String showAddBookForm(Model model){
		model.addAttribute("shout", new Shout());
		model.addAttribute("loggedInUsers",userRepository.findLoggedInUsers());
		
		return "index";
	}
	
	@ModelAttribute("loggedUser")
	public User getLoggedUser(HttpServletRequest request){
		if(request.getSession().getAttribute("userId")!= null){
			return userRepository.findOne((Long) request.getSession().getAttribute("userId"));
		}else{
			User notLoggedIn = new User();
			notLoggedIn.setUsername("niezalogowany uzytkowniku");
			notLoggedIn.setLoggedIn(false);
			return notLoggedIn;
		}
	}
	
	@ModelAttribute("shouts")
	public List<Shout> getShouts(){
		return shoutRepository.findRecentShouts();
		
	}
}
