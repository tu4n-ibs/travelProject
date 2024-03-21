package org.example.travelproject.service.Impl;

import org.example.travelproject.model.Booking;
import org.example.travelproject.repository.IBookingRepository;
import org.example.travelproject.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookingService implements IBookingService {
    @Autowired
    private IBookingRepository iBookingRepository;
    @Override
    public Iterable<Booking> findAll() {
        return iBookingRepository.findAll();
    }

    @Override
    public Optional<Booking> findById(int id) {
        return iBookingRepository.findById(id);
    }

    @Override
    public Booking save(Booking booking) {
        return iBookingRepository.save(booking);
    }

    @Override
    public void remove(int id) {
        iBookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> findAllByUserId(int id) {
        return iBookingRepository.findAllByUserId(id);
    }
}
