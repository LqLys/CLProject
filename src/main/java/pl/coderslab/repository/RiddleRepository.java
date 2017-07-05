package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Riddle;

public interface RiddleRepository extends JpaRepository<Riddle,Long>{

}
