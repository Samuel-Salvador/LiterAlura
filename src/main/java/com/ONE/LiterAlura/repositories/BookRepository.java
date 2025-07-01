package com.ONE.LiterAlura.repositories;

import com.ONE.LiterAlura.models.Book;
import com.ONE.LiterAlura.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findBooksByLanguage(Language language);
}
