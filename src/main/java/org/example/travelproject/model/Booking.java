package org.example.travelproject.model;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;
    private String dateGo;
    private String dateBack;
    private String paymentMethod;
    @ManyToOne
    @JoinColumn(name = "booking_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "booking_tour")
    private Tour tour;

    public Booking() {
    }

    public Booking(int booking_id, String dateGo, String dateBack, String paymentMethod) {
        this.booking_id = booking_id;
        this.dateGo = dateGo;
        this.dateBack = dateBack;
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getDateGo() {
        return dateGo;
    }

    public void setDateGo(String dateGo) {
        this.dateGo = dateGo;
    }

    public String getDateBack() {
        return dateBack;
    }

    public void setDateBack(String dateBack) {
        this.dateBack = dateBack;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
