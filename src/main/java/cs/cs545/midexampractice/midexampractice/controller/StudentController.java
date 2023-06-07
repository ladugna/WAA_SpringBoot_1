package cs.cs545.midexampractice.midexampractice.controller;

import cs.cs545.midexampractice.midexampractice.aop.Alert;
import cs.cs545.midexampractice.midexampractice.model.Student;
import cs.cs545.midexampractice.midexampractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentById(@PathVariable("id") long id){
        return studentService.findStudentById(id);
    }
  @Alert
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.save(student);
    }
    @Alert
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") long id){
    studentService.deleteStudentById(id);
    }
    @GetMapping("/{sid}/courses")
    public ResponseEntity<?> getCoursesByStudent(@PathVariable long sid){
        return new ResponseEntity<>(studentService.
                findCoursesByStudent(sid),HttpStatus.OK);
    }
    @GetMapping("/filter")
    public ResponseEntity<?> getStudentByGpa(@RequestParam("num") int num){
        return new ResponseEntity<>(studentService.findStudentByGpa(num),HttpStatus.OK);
    }
    @Alert
    @PutMapping("/{id}")
    public void updateById(@PathVariable("id") long id,
                                        @RequestBody(required = false) Student student){
         studentService.updateById(id,student);
    }
}
