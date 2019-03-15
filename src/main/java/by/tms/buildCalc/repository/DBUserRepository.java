package by.tms.buildCalc.repository;

import by.tms.buildCalc.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DBUserRepository implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = false)
	@Override
	public boolean saveUser(User userFromForm) {
		User userFromDB;
		userFromDB = entityManager.createNamedQuery("User.findUserByEmail",User.class).getSingleResult();
		if (userFromDB.getEmail().equals(userFromForm.getEmail())) {
			return false;
		}
		entityManager.persist(userFromForm);
		return true;
	}

	@Override
	public User getUser(String email, String pass) {
		return entityManager.createNamedQuery("User.findUserByEmailAndPass", User.class)
				.setParameter("email", email)
				.setParameter("pass", pass)
				.getSingleResult();
	}

	@Override
	public List<User> getUserList() {
		return entityManager.createNamedQuery("User.findAllUsers", User.class)
				.getResultList();
	}
}
