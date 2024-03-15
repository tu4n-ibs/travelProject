package org.example.travelproject.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;
    private String service_name;
    private int service_price;
    private String service_status;
    private int service_quantity;

    @ManyToMany(mappedBy = "service")
    private Set<Bill> bill;


    public Service() {
    }

    public Service(int service_id, String service_name, int service_price, String service_status, int service_quantity) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_price = service_price;
        this.service_status = service_status;
        this.service_quantity = service_quantity;
    }

    public Set<Bill> getBill() {
        return bill;
    }

    public void setBill(Set<Bill> bill) {
        this.bill = bill;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getService_price() {
        return service_price;
    }

    public void setService_price(int service_price) {
        this.service_price = service_price;
    }

    public String getService_status() {
        return service_status;
    }

    public void setService_status(String service_status) {
        this.service_status = service_status;
    }

    public int getService_quantity() {
        return service_quantity;
    }

    public void setService_quantity(int service_quantity) {
        this.service_quantity = service_quantity;
    }

}
