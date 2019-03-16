package by.tms.buildCalc.repository;

import by.tms.buildCalc.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DBUserRepository implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

//	//================================= rev1 ====================================================
//
//	@Transactional(readOnly = false)
//	@Override
//	public boolean saveUser(User userFromForm) {
//
//		boolean isUserPresent = true;
//
//		try {
//
//			User userFromDB = entityManager // если нашел, то такой пользователь уже есть, значит дубль !!!
//					.createNamedQuery("User.findUserByEmail",User.class)
//					.setParameter("email",userFromForm.getEmail())
//					.getSingleResult();
//			isUserPresent = true; // пускай будет для наглядности
//
//		} catch (NoResultException noResultException) {
//
////			userFromDB = new User(); // если не нашел, то пользователь уникален, значит флаг присутствие пользователя false
//			isUserPresent = false;
//
//		}
//
//		boolean isUserAdd= false;
//
//		if (isUserPresent == false) { // если уникален, то добавляем
//			entityManager.persist(userFromForm);
//			isUserAdd = true; // отсылаем true, что добавлен
//
//		} else {
//			isUserAdd = false; // если пользователь дублируется, то не добавляем его (пускай будет для наглядности)
//		}
//		return isUserAdd;
//	}

	////================================= rev2 ====================================================
	@Transactional(readOnly = false)
	@Override
	public boolean saveUser(User userFromForm) {
		try {
			entityManager.persist(userFromForm);
			return true; // если ошибок не возникло, значит email пользователя уникален, значит добавление прошло успешно
		} catch (NonUniqueResultException nonUniqueResultException){
			return false; // если возникла ошибка, значит пользователь с таким email уже есть, и добавление не произошло
		}
	}

	@Override
	public User getUser(String email, String pass) {
		try{

			return entityManager.createNamedQuery("User.findUserByEmailAndPass", User.class)
					.setParameter("email", email)
					.setParameter("pass", pass)
					.getSingleResult(); // если ошибок небыло, значит нашел пользователя с такими email и pass и возвращает заполненного найденного пользователя

		} catch (NoResultException noResultException){
			return new User(); // если возникла ошибка, значит такого пользователя нет в базе, то возвращает пустого пользователя
		}

	}

	@Override
	public List<User> getUserList() {
		try{
			return entityManager.createNamedQuery("User.findAllUsers", User.class)
					.getResultList(); // если ошибок небыло, значит в базе есть пользователи и возвращается список этих пользователей
		}catch (NoResultException noResultException){
			return new ArrayList<User>(); // если возникла ошибка, значит база пользователей пуска и возвращается пустой ArrayList
		}
	}
}
