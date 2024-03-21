package org.example.travelproject.service;

import org.example.travelproject.model.Bill;

import java.util.Optional;

public interface IBillService {
    Iterable<Bill> findAll();

    Optional<Bill> findById(int id);

    Bill save(Bill bill);

    void remove(int id);
}
