package org.example.travelproject.repository;

import org.example.travelproject.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITourRepository extends JpaRepository<Tour,Integer> {
    Page<Tour> findAllByNameContains(Pageable pageable, String keyword);
}
