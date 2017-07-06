package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.model.Riddle;
import pl.coderslab.repository.RiddleRepository;

public class RiddleConverter implements Converter<String, Riddle>{
	@Autowired
	private RiddleRepository riddleRepository;
	
	@Override
	public Riddle convert(String levelId) {
		Riddle riddle = riddleRepository.findOne(Long.parseLong(levelId));
		return riddle;
	}

}
