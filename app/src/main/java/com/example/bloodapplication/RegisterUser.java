package com.example.bloodapplication;

public class RegisterUser {

    public String name, email, phone,bloodgroup,password;

    public RegisterUser(){
    }

    public RegisterUser(String name, String email, String phone, String bloodgroup, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bloodgroup = bloodgroup;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
