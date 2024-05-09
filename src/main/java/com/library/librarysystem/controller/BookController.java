package com.library.librarysystem.controller;

import com.library.librarysystem.entity.Book;
import com.library.librarysystem.sevice.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
//        Here we get the list Of books
        List<Book> books = bookService.findAllBooks();
//        Here we take the list and render it using the model add attribute
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String viewBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "list-book";

    }
}
