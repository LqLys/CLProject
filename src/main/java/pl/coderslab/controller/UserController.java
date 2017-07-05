package pl.coderslab.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

@Controller
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "userForm";

	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "userForm";
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setMaxHealth(1000);
			user.setCurrentHealth(1000);
			userRepository.save(user);
			model.addAttribute("user", user);

			return "redirect:/users/login";
		}
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "userLogin";
	}
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute User user, Model model, HttpServletRequest request) {
		User userToCheck = userRepository.findByEmail(user.getEmail());

		if (userToCheck != null && passwordEncoder.matches(user.getPassword(), userToCheck.getPassword())) {
			userToCheck.setLoggedIn(true);
			userRepository.save(userToCheck);
			request.getSession().setAttribute("userId", userToCheck.getId());
			return "redirect:/";
		} else {
			request.getSession().removeAttribute("userId");
			return "invalid login or password";
		}
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logoutUser(HttpServletRequest request) {
		User userToLogOut = userRepository.findOne((Long) request.getSession().getAttribute("userId"));
		
		userToLogOut.setLoggedIn(false);
		userRepository.save(userToLogOut);
		request.getSession().removeAttribute("userId");
		return "redirect:/";

	}
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String showUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "userList";

	}
	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String showEditUserForm(@PathVariable Long id, Model model) {
		model.addAttribute("user", userRepository.findOne(id));
		return "editUserForm";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
	public String processEditUserForm(@ModelAttribute User user, Model model) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "redirect:/users/list";
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBookConfirm(@PathVariable Long id, Model model) {
		model.addAttribute("idOfUser", id);
		return "deleteUserConfirm";
	}

	@RequestMapping(path = "/delete/Confirmed/{id}", method = RequestMethod.GET)
	public String deleteBookConfirmed(@PathVariable Long id, HttpServletRequest request) {
		userRepository.delete(id);
		return "redirect:/users/list";
	}
}
