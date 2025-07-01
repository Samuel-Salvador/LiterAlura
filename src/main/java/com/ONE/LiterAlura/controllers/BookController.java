package com.ONE.LiterAlura.controllers;

import com.ONE.LiterAlura.models.Book;
import com.ONE.LiterAlura.services.AuthorService;
import com.ONE.LiterAlura.services.BookService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController( BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public Book getBookByTitle(String bookTitle) {
        Book book = bookService.searchBookByTitle(bookTitle);
        authorService.addSearchedAuthorsToList(book.getAuthor());
        return book;
    }

    public List<Book> getSearchedBooks(){
        return bookService.getSearchedBooks();
    }

    public List<Book> getFilteredBooksByLanguage(String language){
        return bookService.filterBooksByLanguage(language);
    }

}
