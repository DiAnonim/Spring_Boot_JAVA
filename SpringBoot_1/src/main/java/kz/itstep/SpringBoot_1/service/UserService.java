package kz.itstep.SpringBoot_1.service;

import kz.itstep.SpringBoot_1.exceptions.UserExistException;
import kz.itstep.SpringBoot_1.exceptions.UserNotFoundException;
import kz.itstep.SpringBoot_1.model.User;
import kz.itstep.SpringBoot_1.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IUserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @SneakyThrows
    public User getUserByName(String user_name) {
       User user = userRepository.findByName(user_name);
       if (user == null) {
           throw new UserNotFoundException("User" + user_name + " not found");
       }
       return user;
    }


    public User getUserById(int user_id) {
        Optional<User> user = userRepository.findById(user_id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User createUser(User user) {
        checkUserExist(user.getUser_name());
        if (user != null) {
            return userRepository.save(user);
        }
        return null;
    }


    public User updateUser(int user_id, User user) {
        checkUserExist(user.getUser_name());
        Optional<User> oldUser = userRepository.findById(user_id);
        if (oldUser.isPresent()) {
            User updatedUser = oldUser.get();
            updatedUser.setUser_name(user.getUser_name());
            updatedUser.setUser_pass(user.getUser_pass());
            return userRepository.save(updatedUser);
        }
        return null;
    }

    public boolean deleteUser(int user_id) {
        Optional<User> oldUser = userRepository.findById(user_id);
        if (oldUser.isPresent()) {
            userRepository.deleteById(user_id);
            return true;
        }
        return false;
    }

    @SneakyThrows
    private void checkUserExist(String user_name) {
        if (userRepository.findByName(user_name) != null) {
            throw new UserExistException("User" + user_name + " already exist");
        }
    }

}
