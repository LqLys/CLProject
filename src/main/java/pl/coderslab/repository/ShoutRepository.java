package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.model.Shout;



public interface ShoutRepository extends JpaRepository<Shout,Long> {
	List<Shout> findAllByOrderByCreatedDesc();
	@Query(value = "SELECT * FROM shouts ORDER BY created DESC LIMIT 30", nativeQuery=true)
	List<Shout> findRecentShouts();
	
	
	
}
