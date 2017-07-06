package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.model.Answer;
import pl.coderslab.repository.AnswerRepository;

public class AnswerConverter implements Converter<String, Answer>{
	@Autowired
	private AnswerRepository answerRepository;
	
	@Override
	public Answer convert(String levelId) {
		Answer answer = answerRepository.findOne(Long.parseLong(levelId));
		return answer;
	}
}
