package pl.coderslab.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.model.Answer;
import pl.coderslab.model.DungeonDTO;
import pl.coderslab.model.Riddle;
import pl.coderslab.repository.RiddleRepository;

@Service
public class RiddleService {
	@Autowired
	private RiddleRepository riddleRepository;
	
	public Riddle generateRandomRiddle(){
		int nrOfRiddles = riddleRepository.getNumberOfRiddles();
		int riddleNr = new Random().nextInt(nrOfRiddles)+1;
		Riddle riddle = riddleRepository.findOne((long) riddleNr);
		
		return riddle;
	}
	
	public List<String> getAnswersFromRiddle(Riddle riddle){
		List<String>answers = new ArrayList<>();
		for(Answer a : riddle.getAnswers()){
			answers.add(a.getText());
		}
		return answers;
	}
	
	public List<String> getAnswersOfUser(DungeonDTO dungeonDTO){
		List<String> dtoStrings = dungeonDTO.getAnswersStr();
		return dtoStrings;
	}
	

}
