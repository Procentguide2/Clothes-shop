package com.shop.e_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "is_admin", length = 1)
    private String is_admin;

    public User(String email, String password, String is_admin) {
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public User(){

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsAdmin() {
        return is_admin;
    }

    public void setIsAdmin(String isAdmin) {
        this.is_admin = isAdmin;
    }

}