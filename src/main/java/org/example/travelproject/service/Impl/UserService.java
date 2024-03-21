package org.example.travelproject.service.Impl;

import org.example.travelproject.model.Role;
import org.example.travelproject.model.Tour;
import org.example.travelproject.model.User;
import org.example.travelproject.repository.IUserRepository;
import org.example.travelproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Iterable<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return iUserRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public void remove(int id) {
        iUserRepository.deleteById(id);
    }
    @Override
    public User findByUser(String email) {
        return iUserRepository.findByEmail(email);
    }

}
