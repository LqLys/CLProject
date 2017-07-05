package pl.coderslab.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.coderslab.model.Shout;
import pl.coderslab.repository.ShoutRepository;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("/shouts")
public class ShoutController {

	@Autowired
	private ShoutRepository shoutRepository;
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String findAllShouts(Model model) {
		model.addAttribute("shouts", shoutRepository.findAllByOrderByCreatedDesc());
		model.addAttribute("shout", new Shout());
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String ProcessShout(@Valid @ModelAttribute Shout shout, BindingResult result, Model model,
			HttpServletRequest request) {
		if (request.getSession().getAttribute("userId") != null) {
			Shout shoutToAdd = shout;
			shoutToAdd.setUser(userRepository.findOne((Long) request.getSession().getAttribute("userId")));
			shoutRepository.save(shoutToAdd);
		}
		return "redirect:/";
	}

}
