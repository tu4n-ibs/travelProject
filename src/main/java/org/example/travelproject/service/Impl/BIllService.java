package org.example.travelproject.service.Impl;

import org.example.travelproject.model.Bill;
import org.example.travelproject.model.User;
import org.example.travelproject.repository.IBillRepository;
import org.example.travelproject.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BIllService implements IBillService {
    @Autowired
    private IBillRepository iBillRepository;
    @Override
    public Iterable<Bill> findAll() {
        return iBillRepository.findAll();
    }

    @Override
    public Optional<Bill> findById(int id) {
        return iBillRepository.findById(id);
    }

    @Override
    public Bill save(Bill bill) {
        return iBillRepository.save(bill);
    }

    @Override
    public void remove(int id) {
        iBillRepository.deleteById(id);
    }
}
