package cs.cs545.midexampractice.midexampractice.repository;

import cs.cs545.midexampractice.midexampractice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("select a from Author a join a.books b where b.isbn=:isbn")
    List<Author> findAuthorByBookISBN(@Param("isbn") long isbn);
}
