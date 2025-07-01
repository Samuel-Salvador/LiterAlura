package com.ONE.LiterAlura.services;

import com.ONE.LiterAlura.controllers.GutendexAPI;
import com.ONE.LiterAlura.models.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookService {

    private static final GutendexAPI gutendexAPI = new GutendexAPI();
    private static final List<Book> searchedBooks = new ArrayList<>();

    public static List<Book> getSearchedBooks() {
        return searchedBooks;
    }

    public static Book getBookByTitle(String bookTitle) {
        Optional<Book> bookOptional = gutendexAPI.getDataByTitle(bookTitle);
        if(bookOptional.isPresent()){
            searchedBooks.add(bookOptional.get());
            AuthorService.addSearchedAuthorsToList(bookOptional.get().getAuthors().getFirst());
            return bookOptional.get();
        }
        return null;
    }

    public static List<Book> filterBooksByLanguage(String language){
        if(language.length()>2){
            return searchedBooks.stream()
                    .filter(b-> b.getLanguages().getLanguage().equals(language.toLowerCase())).collect(Collectors.toList());
        } else if (language.length() == 2){
            return searchedBooks.stream()
                    .filter(b->b.getLanguages().toString().equals(language.toLowerCase())).collect(Collectors.toList());
        } else return Collections.emptyList();
    }
}
