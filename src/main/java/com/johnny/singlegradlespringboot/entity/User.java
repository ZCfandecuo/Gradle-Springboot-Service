package com.johnny.singlegradlespringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "company") String company;
    @Column(name = "age") int age;

    public User(Integer id, String name, String company, int age) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.age = age;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getAge() {
        return age;
    }
}

