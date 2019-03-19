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
@Transactional
public class DBUserRepository implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

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

	@Override
	public boolean delUser(User userForDelete) {
		try{
			entityManager.remove(userForDelete);
			return true; // пользователь был успешно удален из БД
		}catch (IllegalArgumentException illegalArgumentException){
			return false; // если возникла ошибка, значит пользователь удален небыл.
		}
	}
}
