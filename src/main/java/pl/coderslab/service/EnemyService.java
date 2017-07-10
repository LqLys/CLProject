package pl.coderslab.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.model.Enemy;
import pl.coderslab.repository.EnemyRepository;

@Service
public class EnemyService {

	@Autowired
	private EnemyRepository enemyRepository;
	
	public Enemy generateRandomEnenmy(){
		int numberOfEnemies = enemyRepository.getNumberOfEnemies();
		int enemyNr = new Random().nextInt(numberOfEnemies)+1;
		Enemy enemy = enemyRepository.findOne((long) enemyNr);
		
		return enemy;
	}
	
	
}
