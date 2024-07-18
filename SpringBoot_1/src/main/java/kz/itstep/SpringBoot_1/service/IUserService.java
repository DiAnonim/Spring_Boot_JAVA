package kz.itstep.SpringBoot_1.service;

import kz.itstep.SpringBoot_1.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserByName(String user_name);
    User getUserById(int user_id);
    User createUser(User user);
    User updateUser(int user_id, User user);
    boolean deleteUser(int user_id);
}
