package org.example.travelproject.service.Impl;

import org.example.travelproject.model.Tour;
import org.example.travelproject.repository.ITourRepository;
import org.example.travelproject.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TourService implements ITourService {
    @Autowired
    ITourRepository tourRepository;
    @Override
    public Page<Tour> findAll(Pageable pageable) {
        return tourRepository.findAll(pageable);
    }

    @Override
    public Optional<Tour> findById(int id) {
       return tourRepository.findById(id);
    }

    @Override
    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public void remove(int id) {
        tourRepository.deleteById(id);
    }

    @Override
    public Page<Tour> findAllByName(Pageable pageable,String name) {
        return tourRepository.findAllByNameContains(pageable,name);
    }
}
