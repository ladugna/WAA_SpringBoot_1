package cs.cs545.midexampractice.midexampractice.controller;

import cs.cs545.midexampractice.midexampractice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(authorService.findAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/filterIsbn")
    public ResponseEntity<?> findBookByIsbn(@RequestParam("isbn") long isbn){
        return new ResponseEntity<>(authorService.findAuthorByBookISBN(isbn),HttpStatus.OK);
    }
}
