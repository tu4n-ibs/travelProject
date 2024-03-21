package org.example.travelproject.service;

import org.example.travelproject.model.Role;
import org.example.travelproject.model.Tour;
import org.example.travelproject.model.User;

import java.util.Optional;

public interface IUserService {
    Iterable<User> findAll();
    Optional<User> findById(int id);
    User save(User user);
    void remove(int id);
    User findByUser(String email);
}
