package pl.coderslab.model;

import java.util.List;

public class DungeonDTO {
	private String name;
	private User user;
	private Level level;
	private Riddle riddle;
	private List<Answer>answers;
	private List<String>answersStr;
	private Enemy enemy;
	
	public DungeonDTO(){};
	public DungeonDTO(Riddle riddle) {
		super();
		this.riddle = riddle;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Riddle getRiddle() {
		return riddle;
	}
	public void setRiddle(Riddle riddle) {
		this.riddle = riddle;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public Enemy getEnemy() {
		return enemy;
	}
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAnswersStr() {
		return answersStr;
	}
	public void setAnswersStr(List<String> answersStr) {
		this.answersStr = answersStr;
	}
	
	
	

}
