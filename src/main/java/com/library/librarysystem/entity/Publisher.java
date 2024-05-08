package com.library.librarysystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Entity
//Naming our database Table
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //    Customizing our database columns.
    @Column(name = "name",length = 100, nullable = false, unique = true)
    private String name;

    //    Defining the relationship between publisher and book entities
    @ManyToMany(mappedBy = "publishers", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

    public Publisher(String name) {
        this.name = name;
    }
}
