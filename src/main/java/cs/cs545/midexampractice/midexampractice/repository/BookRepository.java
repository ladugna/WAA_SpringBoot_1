package cs.cs545.midexampractice.midexampractice.repository;

import cs.cs545.midexampractice.midexampractice.model.Author;
import cs.cs545.midexampractice.midexampractice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select a from Author a join a.books b where b.isbn=:isbn")
    List<Author> findAuthorByBook(@Param("isbn") long isbn);

    @Query("select b from Book b where size(b.authors) =:numOfAuths")
   // @Query("select b from Book b join b.authors a where p(a.size)=:numOfAuths")
    List<Book> findBookByAuths(@Param("numOfAuths") int numOfAuths);

    @Query("select b from Book b join b.authors a join a.address ad where " +
            "ad.country=:country and b.category.category_id=:id")
    List<Book> findByCriteria(@Param("country")String country, @Param("id") long id );
}
