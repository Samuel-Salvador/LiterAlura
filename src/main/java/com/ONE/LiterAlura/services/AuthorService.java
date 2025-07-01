package com.ONE.LiterAlura.services;

import com.ONE.LiterAlura.models.Author;
import com.ONE.LiterAlura.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final List<Author> searchedAuthors;

    public AuthorService(AuthorRepository authorRepository) {
        this.searchedAuthors = authorRepository.findAll();
    }

    public List<Author> getSearchedAuthors() {
        return searchedAuthors;
    }

    public void addSearchedAuthorsToList(Author newAuthor){
        searchedAuthors.add(newAuthor);
    }

    public List<Author> getSearchedAuthorsAliveIn(Integer year){
        return searchedAuthors.stream().filter(a -> a.isAliveIn(year)).collect(Collectors.toList());
    }

}
