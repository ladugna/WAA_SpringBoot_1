package cs.cs545.midexampractice.midexampractice.service;

import cs.cs545.midexampractice.midexampractice.model.Course;
import cs.cs545.midexampractice.midexampractice.model.Student;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findStudentById(long id);
   void updateById(long id, Student student);
    void save(Student student);
    void deleteStudentById(long id);
    List<Course> findCoursesByStudent(@Param("id") long id);
    List<Student> findStudentByGpa(@Param("num") int num);
}
