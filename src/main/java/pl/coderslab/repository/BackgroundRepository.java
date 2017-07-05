package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.model.Background;

public interface BackgroundRepository extends JpaRepository<Background,Long>{
	@Query(value=("SELECT COUNT(*) FROM backgrounds"), nativeQuery=true)
	int getNumberOfBackgrounds();

}
