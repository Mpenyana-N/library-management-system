package com.library.librarysystem.sevice;

import com.library.librarysystem.entity.Book;
import com.library.librarysystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //    Here we find and return the list of books.
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    //    Here we find a specific book by id and return it.
    public Book findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return book;
    }

    //    Here we save a book on the database.
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
    //    First we find the book with a specific id
        Book book;
        book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with " + ' ' + id));
        //    When the required book is found then we delete it from the database
        bookRepository.deleteById(book.getId());
    }


}
