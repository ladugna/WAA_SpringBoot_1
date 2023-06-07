package cs.cs545.midexampractice.midexampractice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long address_id;
    private String city;
    private String state;
    private String zipcode;
    @JsonBackReference
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private Student student;
}
