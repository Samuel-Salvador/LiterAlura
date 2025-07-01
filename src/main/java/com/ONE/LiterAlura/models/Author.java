package com.ONE.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonProperty("birth_year")
    private Integer birthYear;

    @JsonProperty("death_year")
    private Integer deathYear;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> bookList;

    public Author() {
    }

    public String getName() {
        return name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public boolean isAliveIn(Integer year){
        if(year <= deathYear && year >= birthYear){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n\tNome: "+name+
                "\n\tAno de nascimento: "+birthYear+
                "\n\tAno de morte: "+deathYear +
                "\n\tLivros: "+bookList.stream().map(Book::getTitle).toList();
    }
}
