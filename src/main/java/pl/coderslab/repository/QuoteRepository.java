package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote,Long>{
	List<Quote> findByEnemyId(Long id);

}
