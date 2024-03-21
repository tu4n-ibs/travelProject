package org.example.travelproject.service;

import org.example.travelproject.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITourService {
    Page<Tour> findAll(Pageable pageable);
    Optional<Tour> findById(int id);
    Tour save(Tour tour);
    void remove(int id);
    Page<Tour> findAllByName(Pageable pageable, String keyword);
}
