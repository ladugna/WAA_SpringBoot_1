package cs.cs545.midexampractice.midexampractice.controller;

import cs.cs545.midexampractice.midexampractice.model.Book;
import cs.cs545.midexampractice.midexampractice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
  @Autowired
  private BookService bookService;
@GetMapping
public ResponseEntity<?> getAllBooks(){
    return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
}
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById( @PathVariable("id") long id){
        return new ResponseEntity<>(bookService.findBooksById(id), HttpStatus.OK);
    }
  @PutMapping("/{id}")
    public void updateById(@PathVariable("id") long id, @RequestBody Book book){
      bookService.updateById(id, book);
    }
 @PostMapping
 public void addNewBook(@RequestBody Book book){
       bookService.save(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") long id){
    bookService.deleteBookById(id);
    }


    @GetMapping("/filter")
    public ResponseEntity<?> findBookByAuths(@RequestParam("numOfAuths") int numOfAuths){
    return new ResponseEntity<>(bookService.findBookByAuths(numOfAuths), HttpStatus.OK);
    }

    @GetMapping("/filterByCriteria")
    public ResponseEntity<?> findByCriteria(@RequestParam("country")String country, @RequestParam("id") long id ){
    return new ResponseEntity<>(bookService.findByCriteria(country, id), HttpStatus.OK);
    }
    @GetMapping("/filterTitle")
    public ResponseEntity<?> searchReviews(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "price") Double price){
        return new ResponseEntity<>(bookService.searchReviewCriteria( title,price),HttpStatus.OK);
    }
}
