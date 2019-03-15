package by.tms.buildCalc.repository;

import by.tms.buildCalc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ListUserRepository implements UserRepository {
	
	List<User> userList = new ArrayList<>();

	@Override
	public boolean saveUser(User userFromForm) {
		boolean isUserSave = false;
		boolean isUserPresent = false;
		for (User userInList : userList) {
			if (userInList.getEmail().equals(userFromForm.getEmail())){
				isUserPresent = true;
				break;
			}
		}
		if (!isUserPresent){
			Long id = Long.valueOf(userList.size());
			userFromForm.setId(id);
			userList.add(userFromForm);
			isUserSave = true;
		}
		return isUserSave;
	}

	@Override
	public User getUser(String email, String pass) {
		for (User userInList : userList) {
			if (userInList.getEmail().equals(email)){
				if (userInList.getPass().equals(pass)){
					return userInList;
				}
			}
		}
		User userNotFound = new User();
		userNotFound.setName("Guest");
		return userNotFound;
	}

	@Override
	public List<User> getUserList() {
		return userList;
	}
}
