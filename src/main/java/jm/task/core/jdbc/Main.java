package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        // Создание 4 User-ов
        User firstUser = new User("Pedro", "Popov", (byte) 12);
        User secondUser = new User("Alan", "Pepe", (byte) 32);
        User thirdUser = new User("Petr", "Petrov", (byte) 41);
        User fourthUser = new User("Drake", "Alanov", (byte) 98);

        //Создание таблицы User
        userService.createUsersTable();

        userService.saveUser(firstUser.getName(), firstUser.getLastName(), firstUser.getAge());
        System.out.println("User с именем" + " - " + firstUser.getName() + " добавлен в базу данных");
        // User 2
        userService.saveUser(secondUser.getName(), secondUser.getLastName(), secondUser.getAge());
        System.out.println("User с именем" + " - " + secondUser.getName() + " добавлен в базу данных");
        // User 3
        userService.saveUser(thirdUser.getName(), thirdUser.getLastName(), thirdUser.getAge());
        System.out.println("User с именем" + " - " + thirdUser.getName() + " добавлен в базу данных");
        // User 4
        userService.saveUser(fourthUser.getName(), fourthUser.getLastName(), fourthUser.getAge());
        System.out.println("User с именем" + " - " + fourthUser.getName() + " добавлен в базу данных");

        // Получение всех User из базы
        List<User> resultList = userService.getAllUsers();
        for (User user : resultList) {
            System.out.println(user.toString());
        }
        // Очистка таблицы User
        userService.cleanUsersTable();

        // Удаление таблицы
        userService.dropUsersTable();

    }
}