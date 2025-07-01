package com.ONE.LiterAlura.services;

import com.ONE.LiterAlura.models.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorService {

    private static final List<Author> searchedAuthors = new ArrayList<>();

    public static List<Author> getSearchedAuthors() {
        return searchedAuthors;
    }

    public static void addSearchedAuthorsToList(Author newAuthor){
        searchedAuthors.add(newAuthor);
    }

    public static List<Author> getSearchedAuthorsAliveIn(Integer year){
        return searchedAuthors.stream().filter(a -> a.isAliveIn(year)).collect(Collectors.toList());
    }

}
