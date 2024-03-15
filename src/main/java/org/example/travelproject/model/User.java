package org.example.travelproject.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String user_name;
    private String user_avatar;
    private String user_phoneNumber;
    private String user_email;
    private String user_password;
    private String user_address;
    private int user_bankAccount;
    private int provider_revenue;
    private int user_card;

    @ManyToOne
    @JoinColumn(name = "user_role")
    private Role role;

    public User() {
    }

    public User(int user_id, String user_name, String user_avatar, String user_phoneNumber, String user_email, String user_password, String user_address, int user_bankAccount, int provider_revenue, int user_card) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_avatar = user_avatar;
        this.user_phoneNumber = user_phoneNumber;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_address = user_address;
        this.user_bankAccount = user_bankAccount;
        this.provider_revenue = provider_revenue;
        this.user_card = user_card;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public String getUser_phoneNumber() {
        return user_phoneNumber;
    }

    public void setUser_phoneNumber(String user_phoneNumber) {
        this.user_phoneNumber = user_phoneNumber;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public int getUser_bankAccount() {
        return user_bankAccount;
    }

    public void setUser_bankAccount(int user_bankAccount) {
        this.user_bankAccount = user_bankAccount;
    }

    public int getProvider_revenue() {
        return provider_revenue;
    }

    public void setProvider_revenue(int provider_revenue) {
        this.provider_revenue = provider_revenue;
    }

    public int getUser_card() {
        return user_card;
    }

    public void setUser_card(int user_card) {
        this.user_card = user_card;
    }

}
