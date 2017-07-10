package pl.coderslab.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pl.coderslab.repository.BackgroundRepository;

@Service
public class BackgroundService {

	@Autowired
	private BackgroundRepository backgroundRepository;
	
	public int generateRandomBackground(){
		
		int nrOfBackgrounds = backgroundRepository.getNumberOfBackgrounds();
		int backgroundNr = new Random().nextInt(nrOfBackgrounds)+1;
		return backgroundNr;
		
	}
	
}
