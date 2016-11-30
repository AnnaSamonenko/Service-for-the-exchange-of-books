package dao;

import entities.User;

import java.util.List;

public interface UserDAO {
    void create(User user);

    void update(int id, User user);

    void delete(int id);

    User read(int id);

    List<User> getAllUsers();

    User findByLogin(String login);
}
