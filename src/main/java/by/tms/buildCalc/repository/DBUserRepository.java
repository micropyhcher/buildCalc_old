package by.tms.buildCalc.repository;

import by.tms.buildCalc.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
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
        boolean isUserSave = false;
        userFromDB = entityManager.find(User.class,userFromForm.getEmail());
        if (!userFromDB.getName().isEmpty()){
            entityManager.persist(userFromDB);
            isUserSave = true;

        }
        return isUserSave;
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
        List<User> userList = new ArrayList<>();
        userList.add(new User((long) 1,"qwe",23,"qwe@qwe.qwe","123123"));
        userList.add(new User((long) 2,"asd",33,"asd@qwe.qwe","123123"));
        userList.add(new User((long) 3,"zxc",56,"zxc@qwe.qwe","123123"));
        userList.add(new User((long) 4,"iop",12,"iop@qwe.qwe","123123"));
        return null;
    }
}
