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

        boolean isUserPresent = false; // существует ли пользователь userFromForm (с таким email) в списке

		for (User userInList : userList) { // поиск пользователя userFromForm (с таким email) в списке
			if (userInList.getEmail().equals(userFromForm.getEmail())){
				isUserPresent = true; // если email найден, значит email не уникален, значит пользователь в писке уже сущетвует
				break;
			}
		}

        boolean isUserSave = false; // выполнено ли сохранение пользователя userFromForm

		if (!isUserPresent){ // если пользователь userFromForm (с таким email) не был найден в списке
			Long id = Long.valueOf(userList.size());
			userFromForm.setId(id);
			userList.add(userFromForm);
			isUserSave = true; // сохранение пользователя userFromForm (с таким email) выполнено
		}
		return isUserSave; // если пользователь userFromForm (с таким email) не уникален (isUserPresent = true), значит сохранение не было выполнено
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
//		User userNotFound = new User();
//		userNotFound.setName("Guest");
		return new User();
	}

	@Override
	public List<User> getUserList() {
		return userList;
	}
}
