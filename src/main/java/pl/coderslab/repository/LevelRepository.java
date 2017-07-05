package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Level;
import pl.coderslab.model.Quote;

public interface LevelRepository extends JpaRepository<Level,Long>{
	List<Level> findByEnemyId(Long id);
}
