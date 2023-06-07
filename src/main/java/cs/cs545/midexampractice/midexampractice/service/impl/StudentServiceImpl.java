package cs.cs545.midexampractice.midexampractice.service.impl;

import cs.cs545.midexampractice.midexampractice.model.Course;
import cs.cs545.midexampractice.midexampractice.model.Student;
import cs.cs545.midexampractice.midexampractice.repository.StudentRepository;
import cs.cs545.midexampractice.midexampractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void updateById(long id, Student student) {
       var student1=studentRepository.findById(id).orElse(null);
        if(student1!=null){
            student1.setName(student.getName());
            student1.setGpa(student.getGpa());
           studentRepository.save(student1);
        }
        else {
            System.out.println("No student found");
        }

    }

    @Override
    public void save(Student student) {
      studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(long id) {
  studentRepository.deleteById(id);
    }

    @Override
    public List<Course> findCoursesByStudent(long id) {
        return studentRepository.findCoursesByStudent(id);
    }

    @Override
    public List<Student> findStudentByGpa(int num) {
        return studentRepository.findStudentByGpa(num);
    }
}
