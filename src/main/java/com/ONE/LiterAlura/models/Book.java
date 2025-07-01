package com.ONE.LiterAlura.models;

import com.ONE.LiterAlura.DTO.SearchDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {


    private Long id;

    private String title;
    private List<Author> authors ;

    @JsonProperty("summaries")
    private List<String> summary ;

    private List<String> languages;

    @JsonProperty("download_count")
    private Integer downloadCount;

    public Book() {
    }

    public Book(SearchDTO searchDTO) {
        this.id = searchDTO.results().getFirst().getId();
        this.title = searchDTO.results().getFirst().getTitle();
        this.authors = searchDTO.results().getFirst().getAuthors();
        this.summary = searchDTO.results().getFirst().getSummary();
        this.languages = searchDTO.results().getFirst().getLanguages();
        this.downloadCount = searchDTO.results().getFirst().getDownloadCount();
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

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    @Override
    public String toString() {
        return "Título: " + title +
                "\nAutores: " + authors +
                "\nSumário: " + summary  ;
    }
}
