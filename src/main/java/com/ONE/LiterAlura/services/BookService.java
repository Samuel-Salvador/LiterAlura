package com.ONE.LiterAlura.services;

import com.ONE.LiterAlura.controllers.GutendexAPI;
import com.ONE.LiterAlura.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookService {

    private static final GutendexAPI gutendexAPI = new GutendexAPI();
    private static final List<Book> searchedBooks = new ArrayList<>();

    public static Book getBookByTitle(String bookTitle) {
        Optional<Book> bookOptional = gutendexAPI.getDataByTitle(bookTitle);
        if(bookOptional.isPresent()){
            searchedBooks.add(bookOptional.get());
            return bookOptional.get();
        }
        return null;
    }

    public static List<Book> filterBooksByLanguage(String language){
        return searchedBooks.stream()
                .filter(b-> b.getLanguages().contains(language)).toList();
    }

    public static List<Book> getSearchedBooks() {
        return searchedBooks;
    }
}
