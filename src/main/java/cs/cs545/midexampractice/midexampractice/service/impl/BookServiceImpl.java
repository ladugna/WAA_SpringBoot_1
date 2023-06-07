package cs.cs545.midexampractice.midexampractice.service.impl;

import cs.cs545.midexampractice.midexampractice.model.Author;
import cs.cs545.midexampractice.midexampractice.model.Book;
import cs.cs545.midexampractice.midexampractice.repository.BookRepository;
import cs.cs545.midexampractice.midexampractice.repository.CriteriaRepo;
import cs.cs545.midexampractice.midexampractice.service.BookService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//@Transactional
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBooksById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void updateById(long id, Book book) {
    var book1=bookRepository.findById(id).orElse(null);
   if(book1!=null){
       book1.setTitle(book.getTitle());
       book1.setPrice(book.getPrice());
       bookRepository.save(book1);
   }
   else {
       System.out.println("No book sent");
   }
    }

    @Override
    public void save(Book book) {
      bookRepository.save(book);
    }

    @Override
    public void deleteBookById(long id) {
      bookRepository.deleteById(id);
    }



    @Override
    public List<Book> findBookByAuths(int numOfAuths) {
        return bookRepository.findBookByAuths(numOfAuths);
    }

    @Override
    public List<Book> findByCriteria(String country, long id) {
        return bookRepository.findByCriteria(country, id);
    }

    @Autowired
 CriteriaRepo criteriaRepo;
    @Override
    public List<Book> searchReviewCriteria( String title, Double price) {
        var book=new Book();
        book.setPrice(price);
        book.setTitle(title);
          //bookRepository.save(book);
        return criteriaRepo.findAllByCriteria(book);
    }
}
