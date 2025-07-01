package com.ONE.LiterAlura.controllers;

import com.ONE.LiterAlura.DTO.SearchDTO;
import com.ONE.LiterAlura.DTO.SearchedBookDTO;
import com.ONE.LiterAlura.models.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.NoSuchElementException;
import java.util.Optional;

public class GutendexAPI {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();

    private final String baseUrl = "https://gutendex.com/books";

    public GutendexAPI() {
    }

    public Optional<Book> getDataById(Integer id){
        String urlComplement = "/"+id+"/";
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(baseUrl+urlComplement)).build();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return Optional.of(objectMapper.readValue(httpResponse.body(), Book.class));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException ignored){}
        return Optional.empty();
    }

    public Optional<Book> getDataByTitle(String urlComplement){
        String correctUrl = baseUrl+"?search="+urlComplement;
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create( correctUrl )).build();
        ObjectMapper objectMapper = new ObjectMapper();
            try {
                HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                SearchDTO searchDTO = objectMapper.readValue(httpResponse.body(), SearchDTO.class);
                SearchedBookDTO sbDTO = searchDTO.results().getFirst();
                return Optional.of(new Book(sbDTO));
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            } catch (NoSuchElementException ignored){}
            return Optional.empty();
    }
}
