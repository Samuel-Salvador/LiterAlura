package com.ONE.LiterAlura.models;

import com.ONE.LiterAlura.DTO.SearchedBookDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany
    private List<Author> authors ;

    @Enumerated
    private Language language;

    @JsonProperty("download_count")
    private Integer downloadCount;

    public Book() {
    }

    public Book(SearchedBookDTO searchedBookDTODTO) {
        this.id = searchedBookDTODTO.id();
        this.title = searchedBookDTODTO.title();
        this.authors = searchedBookDTODTO.authors();
        this.language = Language.fromString(searchedBookDTODTO.languages().getFirst());
        this.downloadCount = searchedBookDTODTO.downloadCount();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Language getLanguages() {
        return this.language;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    @Override
    public String toString() {
        return "\n\tTítulo: " + title +
                "\n\tAutores: " + authors.stream().map(Author::getName).toList();
    }
}
