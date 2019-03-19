package by.tms.buildCalc.service;

import by.tms.buildCalc.entity.User;

import java.util.List;

public interface UserService {

	boolean saveUser(User userFromForm);
	User getUser(User userFromForm);
	List<User> getUserList();
	boolean delUser(User userForDelete);
}
