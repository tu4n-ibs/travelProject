package org.example.travelproject.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bill_id;
    private int bill_totalAmount;
    private String bill_paymentMethod;


    @OneToOne
    private Booking booking_id;

    @ManyToMany
    @JoinTable(
            name = "bill_service",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> service;


    public Bill() {
    }

    public Bill(int bill_id, int bill_totalAmount, String bill_paymentMethod) {
        this.bill_id = bill_id;
        this.bill_totalAmount = bill_totalAmount;
        this.bill_paymentMethod = bill_paymentMethod;
    }

    public Set<Service> getService() {
        return service;
    }

    public void setService(Set<Service> service) {
        this.service = service;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getBill_totalAmount() {
        return bill_totalAmount;
    }

    public void setBill_totalAmount(int bill_totalAmount) {
        this.bill_totalAmount = bill_totalAmount;
    }

    public String getBill_paymentMethod() {
        return bill_paymentMethod;
    }

    public void setBill_paymentMethod(String bill_paymentMethod) {
        this.bill_paymentMethod = bill_paymentMethod;
    }

    public Booking getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Booking booking_id) {
        this.booking_id = booking_id;
    }
}
