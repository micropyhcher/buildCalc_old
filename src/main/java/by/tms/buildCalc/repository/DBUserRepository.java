package by.tms.buildCalc.repository;

import by.tms.buildCalc.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional (readOnly = true)
public class DBUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = false)
    @Override
    public boolean saveUser(User userFromForm) {
        User userFromDB = new User();
        userFromDB = entityManager.find(User.class,userFromForm.getEmail());
        return false;
    }

    @Override
    public User getUser(String email, String pass) {
        User userFromDB = new User();
        userFromDB = entityManager.find(User.class,email);
        if (userFromDB.getPass().equals(pass)){
            return userFromDB;
        }
        User userNotFound = new User();
        userNotFound.setName("Guest");
        return userNotFound;
    }

    @Override
    public List<User> getUserList() {
        return null;
    }
}
