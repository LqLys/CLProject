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
import pl.coderslab.model.Quote;
import pl.coderslab.repository.EnemyRepository;
import pl.coderslab.repository.QuoteRepository;

@Controller
@RequestMapping("/quotes")
public class QuoteController {
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Autowired
	private EnemyRepository enemyRepository;
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String showQuoteForm(Model model) {
		model.addAttribute("quote", new Quote());
		return "quoteForm";

	}
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String addQuote(@Valid @ModelAttribute Quote quote, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "quoteForm";
		} else {
			quoteRepository.save(quote);
			return "redirect:/quotes/list";
		}
	}
	
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public String showQuotes(Model model){
		model.addAttribute("quotes", quoteRepository.findAll());
		return "quoteList";
		
	}
	
	@RequestMapping(path = "/add/{id}", method = RequestMethod.GET)
	public String showQuoteForm(@PathVariable Long id, Model model) {
		List<Quote> quotes = quoteRepository.findAll();
		return "quoteForm";

	}
	@ModelAttribute("enemies")
	public List<Enemy> getEnemies(){
		return enemyRepository.findAll();
	}
	
	@RequestMapping(path = "/list/{id}", method = RequestMethod.GET)
	public String showEnemyQuotes(@PathVariable Long id, Model model) {
		List<Quote> quotes = quoteRepository.findByEnemyId(id);
		model.addAttribute("quotes", quotes);
		
		return "quoteList";

	}
	

}
