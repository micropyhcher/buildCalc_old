package by.tms.buildCalc.repository;


import by.tms.buildCalc.entity.User;

import java.util.List;

public interface UserRepository {

	boolean saveUser(User userFromForm);
	User getUser(String email, String pass);
	List<User> getUserList();

}
