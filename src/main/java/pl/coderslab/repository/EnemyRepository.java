package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.model.Enemy;

public interface EnemyRepository extends JpaRepository<Enemy,Long>{
	@Query(value=("SELECT COUNT(*) FROM enemies"), nativeQuery=true)
	int getNumberOfEnemies();
	@Query(value="SELECT id FROM enemies", nativeQuery=true)
	List<Long> findIdsOfEnemies();
	

}
