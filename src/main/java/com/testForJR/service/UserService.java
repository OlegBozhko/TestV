package com.testForJR.service;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.testForJR.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service("userService")
@Transactional
public class UserService {
    protected static Logger logger = Logger.getLogger("service");

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public List<User> getAll() {
        logger.debug("Retrieving all users");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User");
        return  query.list();
    }

    public User get(Integer id ) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    public void add(User user) {
        logger.debug("Adding new user");
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public void delete(Integer id) {
        logger.debug("Deleting existing user");
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        session.delete(user);
    }

    public void edit(User user) {
        logger.debug("Editing existing user");
        Session session = sessionFactory.getCurrentSession();
        User existingUser = (User) session.get(User.class, user.getId());
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setAdmin(user.isAdmin());
        session.save(existingUser);
    }

    public List<User> searchUserByName(String searchName) {
        logger.debug("Search user");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User WHERE name like '%" + searchName + "%'");
        return  query.list();
    }
}
