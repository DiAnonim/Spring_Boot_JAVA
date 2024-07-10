package kz.itstep.SpringBoot_1.controller;

import jakarta.validation.Valid;
import kz.itstep.SpringBoot_1.model.User;
import kz.itstep.SpringBoot_1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
//    localhost:8081/
    private final UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PatchMapping("/update/{id}")
    public User updateUser(@Valid @PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}
