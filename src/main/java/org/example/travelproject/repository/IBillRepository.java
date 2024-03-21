package org.example.travelproject.repository;

import org.example.travelproject.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill,Integer> {
}
