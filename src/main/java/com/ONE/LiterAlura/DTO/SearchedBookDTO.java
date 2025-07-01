package com.ONE.LiterAlura.DTO;

import com.ONE.LiterAlura.models.Author;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchedBookDTO(
        Long id,
        String title,
        List<Author> authors,
        List<String> languages,
        @JsonAlias("download_count")
        Integer downloadCount
) {
}
