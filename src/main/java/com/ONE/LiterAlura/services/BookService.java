package com.ONE.LiterAlura.services;

import com.ONE.LiterAlura.controllers.GutendexAPI;
import com.ONE.LiterAlura.models.Book;
import com.ONE.LiterAlura.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final GutendexAPI gutendexAPI;

    private final List<Book> searchedBooks ;

    public BookService(BookRepository bookRepository, GutendexAPI gutendexAPI) {
        this.bookRepository = bookRepository;
        this.gutendexAPI = gutendexAPI;
        this.searchedBooks = bookRepository.findAll();
    }

    public  List<Book> getSearchedBooks() {
        return searchedBooks;
    }

    public Book searchBookByTitle(String bookTitle) {
        String correctTitle = bookTitle.replaceAll("\\s","%20");
        Optional<Book> bookOptional = gutendexAPI.getDataByTitle(correctTitle);
        if(bookOptional.isPresent()){
            Book newBook = bookOptional.get();
            for(Book book : searchedBooks){
                if(newBook.getTitle().equalsIgnoreCase(book.getTitle())){
                   return book;
                }
            }
            bookRepository.save(newBook);
            searchedBooks.add(newBook);
            return newBook;
        }
        return null;
    }

    public List<Book> filterBooksByLanguage(String language){
        if(language.length()>2){
            return searchedBooks.stream()
                    .filter(b-> b.getLanguages().getLanguage().equals(language.toLowerCase())).collect(Collectors.toList());
        } else if (language.length() == 2){
            return searchedBooks.stream()
                    .filter(b->b.getLanguages().toString().equals(language.toLowerCase())).collect(Collectors.toList());
        } else return Collections.emptyList();
    }
}
