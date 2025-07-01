package com.ONE.LiterAlura.DTO;

import com.ONE.LiterAlura.models.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SearchDTO(Integer count,
                        List<SearchedBookDTO> results
                        ) {



}
