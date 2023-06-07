package cs.cs545.midexampractice.midexampractice.repository;

import cs.cs545.midexampractice.midexampractice.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class CriteriaRepo {
    private final EntityManager em;

    public List<Book> findAllByCriteria(Book book){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        List<Predicate> predicates = new ArrayList<>();
        // select * from Review
        Root<Book> root = criteriaQuery.from(Book.class);
        if(book.getTitle()!=null){
            Predicate title=criteriaBuilder.like(root.get("title"), "%"+book.getTitle()+"%");
            predicates.add(title);
        }

      if(book.getPrice()!=null){
          Predicate price=criteriaBuilder.greaterThanOrEqualTo(root.get("price"),book.getPrice());
          predicates.add(price);
      }


        criteriaQuery.where(
                criteriaBuilder.and(predicates.toArray(new Predicate[0]))
        );
        TypedQuery<Book> query = em.createQuery(criteriaQuery);
        return query.getResultList();

    }
}
