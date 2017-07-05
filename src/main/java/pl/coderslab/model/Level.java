package pl.coderslab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="levels")
public class Level {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	@ManyToOne
	private Enemy enemy;
	@OneToOne(mappedBy="level")
	private Dungeon dungeon;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Enemy getEnemy() {
		return enemy;
	}
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
	public Dungeon getDungeon() {
		return dungeon;
	}
	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	
	
	
	

}
