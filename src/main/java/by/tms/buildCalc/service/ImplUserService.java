package by.tms.buildCalc.service;

import by.tms.buildCalc.entity.User;
import by.tms.buildCalc.repository.ListUserRepository;
import by.tms.buildCalc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplUserService implements UserService {

	@Autowired
	private ListUserRepository userRepository;

	@Override
	public boolean saveUser(User userFromForm) {
		return userRepository.saveUser(userFromForm);
	}

	@Override
	public User getUser(User userFromForm) {
		User userFromList = userRepository.getUser(userFromForm.getEmail());
		return userFromList;
	}

	@Override
	public List<User> getUserList() {
		return userRepository.getUserList();
	}
}
