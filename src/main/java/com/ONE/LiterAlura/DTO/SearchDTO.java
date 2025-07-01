package com.ONE.LiterAlura.DTO;

import com.ONE.LiterAlura.models.Book;

import java.util.List;

public record SearchDTO(Integer count,
                        List<Book> results,
                        String next,
                        String previous) {

}
