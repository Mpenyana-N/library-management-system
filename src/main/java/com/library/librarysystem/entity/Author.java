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
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //    Customizing our database columns.
    @Column(name = "name",length = 100, nullable = false, unique = true)
    private String name;

    //    Customizing our database columns.
    @Column(name = "description", length = 250, nullable = false)
    private String description;

    //    Defining the relationship between author and book entities
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
