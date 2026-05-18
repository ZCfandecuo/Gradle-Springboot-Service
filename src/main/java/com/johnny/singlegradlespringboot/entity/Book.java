package com.johnny.singlegradlespringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public record Book(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
                   String name, String publish, String author) {
    public Book{

    }
}
