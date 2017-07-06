package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.model.Riddle;

public interface RiddleRepository extends JpaRepository<Riddle,Long>{
	@Query(value=("SELECT COUNT(*) FROM riddles"), nativeQuery=true)
	int getNumberOfRiddles();

}
