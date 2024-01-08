package com.example.demo.StudentController;


import com.example.demo.Exception.UniversityStudentNotFoundException;
import com.example.demo.Service.UniversityStudentService;
import com.example.demo.modelStudent.UniversityStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class StudentControllerServices {
    @Autowired
    private UniversityStudentService repository;

    @GetMapping(path = "/student")
    public ResponseEntity<List<UniversityStudent>> showAllStudents() {
        return new ResponseEntity<>(repository.findAllStudents(), HttpStatus.OK);
    }

//    @GetMapping(path = "/student/{id}")
//    public ResponseEntity<String> getStudentDetail(@PathVariable long id) {
//        Optional<UniversityStudent> student = repository.findById(id);
//        if (student.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.status(HttpStatus.OK).body("STUDENT FOUND");
//    }


    @GetMapping(path = "/student/{id}")
    public UniversityStudent studentDetail(@PathVariable long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UniversityStudentNotFoundException(id));
    }


    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody UniversityStudent universityStudent) {
        UniversityStudent newStudent = repository.SaveStudent(universityStudent);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(universityStudent.getId())
                .toUri();
        return ResponseEntity.created(location).body("ADD STUDENT SUCCESS");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        Optional<UniversityStudent> CurrentStudent = repository.findById(id);
        if (CurrentStudent.isPresent()) {
            repository.DeleteStudent(CurrentStudent.get());
            return ResponseEntity.ok("DELETE STUDENT SUCCESS");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DELETE FAILED - student not found");
    }


    // advanced way
//    @PutMapping(path = "/student/{id}")
//    public UniversityStudent replaceStudent(@RequestBody UniversityStudent universityStudent, @PathVariable long id) {
//        return repository.findById(id).map(
//                        student -> {
//                            student.setAge(universityStudent.getAge());
//                            student.setId(universityStudent.getId());
//                            student.setName(universityStudent.getName());
//                            student.setEmail(universityStudent.getEmail());
//                            student.setCountry(universityStudent.getCountry());
//                            return repository.SaveStudent(student);
//                        })
//                .orElseGet(() -> {
//                    universityStudent.setId(id);
//                    return repository.SaveStudent(universityStudent);
//                });
//    }
        @PutMapping(path = "/student/{id}")
        public ResponseEntity<String> updateStudent(@RequestBody UniversityStudent student, @PathVariable long id) {
            Optional<UniversityStudent> currentStudent = repository.findById(id);
            if(currentStudent.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            student.setId(student.getId());
            student.setName(student.getName());
            student.setCountry(student.getCountry());
            student.setAge(student.getAge());
            student.setEmail(student.getEmail());
            repository.SaveStudent(student);
            return ResponseEntity.status(HttpStatus.OK).body("UPDATE STUDENT SUCCESS");
        }
}
