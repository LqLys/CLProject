package pl.coderslab.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private  UserRepository userRepository;
	
	public  User getUserFromSession(final HttpServletRequest request){
		return userRepository.findOne((Long) request.getSession().getAttribute("userId"));
		
	}

}
