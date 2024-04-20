package jm.task.core.jdbc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.query.Query;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    private static final SessionFactory sessionFactory = getSessionFactory();
    private Session session;
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS `users` (`id` BIGINT NOT NULL AUTO_INCREMENT, " +
                    "`name` VARCHAR(45) NULL,`lastName` VARCHAR(45) NULL, `age` TINYINT NULL, " +
                    "PRIMARY KEY (`id`))" +
                    " ENGINE = InnoDB DEFAULT CHARACTER SET = utf8";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e){
            if(session != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e){
            if(session != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            User user1 = new User(name, lastName, age);
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(user1);
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            String sql = "DELETE FROM users WHERE id = :id";
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query query = session.createNativeQuery(sql).addEntity(User.class);
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
            //sessionFactory.close();
        } catch (Exception e) {
            if(session != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query query = session.createNativeQuery(sql).addEntity(User.class);
            //List<User> userList = session.createQuery("FROM users", User.class).list();
            userList = query.list();
            session.getTransaction().commit();
            //sessionFactory.close();
        } catch (Exception e) {
            if(session != null) {
                session.getTransaction().rollback();
            }
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        String sql = "delete from users";
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e){
            if(session != null) {
                session.getTransaction().rollback();
            }
        }
    }
}
