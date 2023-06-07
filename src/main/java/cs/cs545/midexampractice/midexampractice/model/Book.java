package cs.cs545.midexampractice.midexampractice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long isbn;
    private String title;
    private Double price;
  @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
@JsonIgnore
    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private List<Author> authors;

}
