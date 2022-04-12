package com.coding.projetweb.controllers;

import java.sql.SQLException;
import java.util.List;


import com.coding.models.User;
import com.coding.services.UserDAO;

import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    private final UserDAO dao = new UserDAO();

    @GetMapping
    public List<User> getUsers() throws SQLException {
        return dao.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value="id") Integer id) throws SQLException{
        return dao.getUserById(id);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user) throws SQLException{
        dao.add(user);
    }

    @PutMapping("/put/{id}")
    public void updateUser(@PathVariable(value="id") Integer id, @RequestBody User user) throws SQLException{
        dao.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void updateUser(@PathVariable(value="id") Integer id) throws SQLException{
        dao.delete(id);
    }

}
