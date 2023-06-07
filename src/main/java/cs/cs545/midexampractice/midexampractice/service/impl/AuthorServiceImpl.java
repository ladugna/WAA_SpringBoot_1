package cs.cs545.midexampractice.midexampractice.service.impl;

import cs.cs545.midexampractice.midexampractice.model.Author;
import cs.cs545.midexampractice.midexampractice.repository.AuthorRepository;
import cs.cs545.midexampractice.midexampractice.repository.BookRepository;
import cs.cs545.midexampractice.midexampractice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
    @Override
    public List<Author> findAuthorByBookISBN(long isbn) {
        return authorRepository.findAuthorByBookISBN(isbn);
    }
}
