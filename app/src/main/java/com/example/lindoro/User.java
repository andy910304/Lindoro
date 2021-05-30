package com.example.lindoro;

public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Company company;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}


