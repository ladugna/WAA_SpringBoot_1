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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long student_id;
    private String name;
    private double gpa;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
    private Address address;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable( name = "Student_Course" ,joinColumns = {
            @JoinColumn(name = "student_id")
    },
    inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courses;
}
