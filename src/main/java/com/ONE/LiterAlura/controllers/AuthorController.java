package com.ONE.LiterAlura.controllers;

import com.ONE.LiterAlura.models.Author;
import com.ONE.LiterAlura.services.AuthorService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<Author> getSearchedAuthors(){
        return authorService.getSearchedAuthors();
    }

    public List<Author> getSearchedAuthorsAliveIn(Integer year){
        return authorService.getSearchedAuthorsAliveIn(year);
    }

}
