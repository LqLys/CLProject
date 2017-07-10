package pl.coderslab.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import pl.coderslab.model.Answer;

@Service
public class AnswerService {

	public List<Answer> getCorrectAnswers(List<Answer> answers) {
		List<Answer> correctAnswers = new ArrayList<>();
		for (Answer a : answers) {
			if (a.isCorrect()) {
				correctAnswers.add(a);
			}
		}
		return correctAnswers;
	}

	public List<Answer> getAnswersFromSession(HttpServletRequest request, String sessionAttribute) {
		return (List<Answer>) request.getSession().getAttribute(sessionAttribute);
	}

	public String getTextOfCorrectAnswers(List<Answer> correctAnswers) {
		String correctAnswersText = "";

		for (Answer a : correctAnswers) {
			correctAnswersText += a.getText() + " ";
		}
		return correctAnswersText;
	}
	
	public int getAmountOfCorrectAnswersFromUser(List<Answer> allAnswers, List<String>userAnswers){
		int correctAnswers = 0;
		for(Answer a : allAnswers){
			for(String s : userAnswers){
				if(a.getText().equals(s) && a.isCorrect()){
					correctAnswers++;
				}
			}
		}
		return correctAnswers;
	}
	
	public boolean evaluateAnswer(List<String> answersOfUser, int numberOfCorrectAnswers){
		return answersOfUser.size() == numberOfCorrectAnswers ? true : false;
	}

}
