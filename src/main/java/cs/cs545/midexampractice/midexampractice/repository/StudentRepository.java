package cs.cs545.midexampractice.midexampractice.repository;

import cs.cs545.midexampractice.midexampractice.model.Course;
import cs.cs545.midexampractice.midexampractice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select c from Course c join c.students s where s.student_id=:id")
    List<Course> findCoursesByStudent(@Param("id") long id);

    @Query("select s from Student s where s.gpa>=:num")
   List<Student> findStudentByGpa(@Param("num") int num);
    //List<Student> findStudentsByGpaIsGreaterThanEqual(@Param("num") int num);
}
