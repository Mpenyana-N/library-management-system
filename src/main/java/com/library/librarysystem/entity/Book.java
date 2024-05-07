package com.library.librarysystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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


    //    The following methods makes sure that when you add or remove a book The other entities have the same effect
    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }

    public void removePublisher(Publisher publisher) {
        this.publishers.remove(publisher);
        publisher.getBooks().remove(publisher);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
        author.getBooks().remove(author);
    }

    public void addCategory(Category category) {
        this.categories.add(category);
        category.getBooks().add(this);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.getBooks().remove(category);
    }
}
