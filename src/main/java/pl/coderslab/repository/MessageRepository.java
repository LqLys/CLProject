package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.model.Message;



public interface MessageRepository extends JpaRepository<Message,Long>{
	@Query("SELECT m FROM Message m where m.receiver.id = ?1 ORDER BY m.created DESC")
	List<Message> findReceivedMessages(Long id);
	@Query("SELECT m FROM Message m where m.sender.id = ?1 ORDER BY m.created DESC")
	List<Message> findSentMessages(Long id);
	
	

}
