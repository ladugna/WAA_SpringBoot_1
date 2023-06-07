package cs.cs545.midexampractice.midexampractice.model;

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
public class Course {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String course_id;
    private String  name;
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST)
    private List<Student> students;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "course")
    private List<Subject> subjects;
}
