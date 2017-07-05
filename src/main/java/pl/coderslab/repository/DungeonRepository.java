package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Dungeon;

public interface DungeonRepository extends JpaRepository<Dungeon,Long>{

}
