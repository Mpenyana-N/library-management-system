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
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //    Customizing our database columns.
    @Column(name = "isbn",length = 50, nullable = false, unique = true)
    private String isbn;

    //    Customizing our database columns.
    @Column(name = "name",length = 100, nullable = false)
    private String name;

    //    Customizing our database columns.
    @Column(name = "description",length = 250, nullable = false)
    private String description;

    //    Defining the relationship between book and author entities
    @ManyToMany(cascade = CascadeType.ALL)
    //    Customizing the joined columns.
    @JoinTable(name = "books_authors", joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")} )
    private Set<Author> authors = new HashSet<Author>();

    //    Defining the relationship between book and category entities
    @ManyToMany(cascade = CascadeType.ALL)

    //    Customizing the joined columns.
    @JoinTable(name = "books_categories", joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")} )
    private Set<Category> categories = new HashSet<Category>();

    //    Defining the relationship between book and publisher entities
    @ManyToMany(cascade = CascadeType.ALL)

    //    Customizing the joined columns.
    @JoinTable(name = "books_publishers", joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "publisher_id")} )
    private Set<Publisher> publishers = new HashSet<Publisher>();
}
