package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


import pl.coderslab.model.Level;
import pl.coderslab.repository.LevelRepository;

public class LevelConverter implements Converter<String, Level>{
	@Autowired
	private LevelRepository levelRepository;
	
	@Override
	public Level convert(String levelId) {
		Level level = levelRepository.findOne(Long.parseLong(levelId));
		return level;
	}

}
