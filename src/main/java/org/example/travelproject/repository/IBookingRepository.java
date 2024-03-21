package org.example.travelproject.repository;

import org.example.travelproject.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findAllByUserId(int id);
}
