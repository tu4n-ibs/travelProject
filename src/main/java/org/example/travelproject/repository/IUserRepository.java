package org.example.travelproject.repository;

import org.example.travelproject.model.User;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
