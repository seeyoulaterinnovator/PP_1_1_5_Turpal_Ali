package jm.task.core.jdbc;

//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        UserDaoHibernateImpl test2 = new UserDaoHibernateImpl();
        test2.createUsersTable();
        test2.saveUser("Pedro","Pachino", (byte) 22);
        System.out.println("User с именем - Pedro добавлен в Базу Данных");
        test2.saveUser("Lilya","Lolo", (byte) 24);
        System.out.println("User с именем - Lilya добавлен в Базу Данных");
        test2.saveUser("Pepe","Olenev", (byte) 24);
        System.out.println("User с именем - Pepe добавлен в Базу Данных");
        test2.saveUser("Ali","Bekov", (byte) 26);
        System.out.println("User с именем - Ali добавлен в Базу Данных");
        System.out.println(test2.getAllUsers());
        test2.dropUsersTable();

    }
}