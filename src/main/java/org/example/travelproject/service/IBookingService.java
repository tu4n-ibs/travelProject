package org.example.travelproject.service;

import org.example.travelproject.model.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Iterable<Booking> findAll();
    Optional<Booking> findById(int id);
    Booking save(Booking booking);
    void remove(int id);
    List<Booking> findAllByUserId(int id);
}
