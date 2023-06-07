package cs.cs545.midexampractice.midexampractice.service;

import cs.cs545.midexampractice.midexampractice.model.Author;
import cs.cs545.midexampractice.midexampractice.model.Book;
import cs.cs545.midexampractice.midexampractice.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookService {
    List<Book> findAll();
  Book findBooksById(long id);
    void updateById(long id, Book book);
    void save(Book book);
    void deleteBookById(long id);

    List<Book> findBookByAuths(@Param("numOfAuths") int numOfAuths);

    List<Book> findByCriteria(@Param("country")String country, @Param("catId") long catId );
  public List<Book> searchReviewCriteria( String title, Double price);
}
