package com.example.dafi.registerapplication;

/**
 * Created by Dafi on 2.5.2016 г..
 */
public class User {

    String name, username, password;
    int id,age;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name ;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username ;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password ;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age ;
    }

    public  User()
    {}

    public  User( String name,String username,
                  String password, int age) {
        this.name =name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public  User(String username, String password) {
        this.name ="";
        this.age = 1;
        this.username = username;
        this.password = password;
    }

}

