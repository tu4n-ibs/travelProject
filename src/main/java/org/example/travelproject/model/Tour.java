package org.example.travelproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tour_id;
    private String tour_name;
    private String tour_picture;
    private int tour_price;
    private String tour_transport;
    private int tour_transportPrice;
    private String tour_benefits;


    public Tour() {
    }

    public Tour(int tour_id, String tour_name, String tour_picture, int tour_price, String tour_transport, int tour_transportPrice, String tour_benefits) {
        this.tour_id = tour_id;
        this.tour_name = tour_name;
        this.tour_picture = tour_picture;
        this.tour_price = tour_price;
        this.tour_transport = tour_transport;
        this.tour_transportPrice = tour_transportPrice;
        this.tour_benefits = tour_benefits;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public String getTour_name() {
        return tour_name;
    }

    public void setTour_name(String tour_name) {
        this.tour_name = tour_name;
    }

    public String getTour_picture() {
        return tour_picture;
    }

    public void setTour_picture(String tour_picture) {
        this.tour_picture = tour_picture;
    }

    public int getTour_price() {
        return tour_price;
    }

    public void setTour_price(int tour_price) {
        this.tour_price = tour_price;
    }

    public String getTour_transport() {
        return tour_transport;
    }

    public void setTour_transport(String tour_transport) {
        this.tour_transport = tour_transport;
    }

    public int getTour_transportPrice() {
        return tour_transportPrice;
    }

    public void setTour_transportPrice(int tour_transportPrice) {
        this.tour_transportPrice = tour_transportPrice;
    }

    public String getTour_benefits() {
        return tour_benefits;
    }

    public void setTour_benefits(String tour_benefits) {
        this.tour_benefits = tour_benefits;
    }
}
