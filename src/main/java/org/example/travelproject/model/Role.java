package org.example.travelproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String name;

    public Role(int roleId) {
        this.roleId = roleId;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }
}
