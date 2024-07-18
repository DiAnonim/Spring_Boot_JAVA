package kz.itstep.SpringBoot_1.controller;

import jakarta.validation.Valid;
import kz.itstep.SpringBoot_1.model.User;
import kz.itstep.SpringBoot_1.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
//    localhost:8081/
    private final IUserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/username/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@Valid @PathVariable int id, @RequestBody User user) {
        return ResponseEntity.accepted().body(userService.updateUser(id, user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return ResponseEntity.accepted().body(userService.deleteUser(id));
    }

}
