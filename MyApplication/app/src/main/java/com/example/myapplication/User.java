package com.example.myapplication;

public class User {
    String password,email,name,phonenumber;

    public User(String password, String email,String name,String phonenumber) {
        super();
        this.password = password;
        this.email = email;
        this.name=name;
        this.phonenumber=phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {this.phonenumber= phonenumber;}


}
