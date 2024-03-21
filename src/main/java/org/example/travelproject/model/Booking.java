package org.example.travelproject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dateGo;
    private String dateBack;
    private String status;
    @ManyToOne
    @JoinColumn(name = "booking_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "booking_tour")
    private Tour tour;
}
