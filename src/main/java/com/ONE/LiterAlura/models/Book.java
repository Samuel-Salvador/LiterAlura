package com.ONE.LiterAlura.models;

import com.ONE.LiterAlura.DTO.SearchedBookDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Author author ;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @JsonProperty("download_count")
    private Integer downloadCount;

    public Book() {
    }

    public Book(SearchedBookDTO searchedBookDTODTO) {
        this.title = searchedBookDTODTO.title();
        this.author = searchedBookDTODTO.authors().getFirst();
        this.language = Language.fromString(searchedBookDTODTO.languages().getFirst());
        this.downloadCount = searchedBookDTODTO.downloadCount();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
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
                "\n\tAutor: " + author.getName();
    }
}
