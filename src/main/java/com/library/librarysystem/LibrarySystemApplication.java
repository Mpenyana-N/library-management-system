package com.library.librarysystem;

import com.library.librarysystem.entity.Author;
import com.library.librarysystem.entity.Book;
import com.library.librarysystem.entity.Category;
import com.library.librarysystem.entity.Publisher;
import com.library.librarysystem.sevice.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibrarySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);
	}
@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return (args) -> {
			Book book1 = new Book("978-0061120084", "To Kill a Mockingbird", "To Kill a Mockingbird is a novel by Harper Lee published in 1960. It is set in the fictional town of Maycomb, Alabama, and follows the experiences of Scout Finch, a young girl whose father, Atticus Finch, is an attorney.");
			Author author1 = new Author("Harper Lee", "American novelist known for To Kill a Mockingbird");
			Category category1 = new Category("Fiction");
			Publisher publisher1 = new Publisher("HarperCollins Publishers");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.saveBook(book1);

			Book book2 = new Book("978-9821120084", "Your Next Five Moves", "Master the Art of Business Strategy");
			Author author2 = new Author("Patrick Bet-David", "American novelist known for Your Next Five Moves");
			Category category2 = new Category("Business Books");
			Publisher publisher2 = new Publisher("Collins Publishers");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.saveBook(book2);

			Book book3 = new Book("978-9823320084", "THE LEAN STARTUP", "Master the Art of Starting a Business");
			Author author3 = new Author("Eric Ries", "American novelist known for The Lean Start up");
			Category category3 = new Category("Novel Books");
			Publisher publisher3 = new Publisher("Lins Publishers");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.saveBook(book3);
		};
	}
}
