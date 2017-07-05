package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.coderslab.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);

	User findByEmail(String email);
	@Query(value=("SELECT * FROM users WHERE loggedIn = true"), nativeQuery=true)
	List<User>findLoggedInUsers();
	

}
