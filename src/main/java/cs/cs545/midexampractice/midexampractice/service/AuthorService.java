package cs.cs545.midexampractice.midexampractice.service;

import cs.cs545.midexampractice.midexampractice.model.Author;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();
    List<Author> findAuthorByBookISBN(@Param("isbn") long isbn);
}
