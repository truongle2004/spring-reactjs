package com.example.demo.StudentController;


import com.example.demo.Reponsitory.RepositoryStudent;
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
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class StudentControllerServices {
    @Autowired
    private UniversityStudentService universityStudentService;

    @GetMapping(path = "/students")
    public ResponseEntity<List<UniversityStudent>> showAllStudents() {
        return new ResponseEntity<>(universityStudentService.findAllStudents(), HttpStatus.OK);
    }

    @GetMapping(path = "/student/{id}")
    public ResponseEntity<String> getStudentDetail(@PathVariable long id) {
        Optional<UniversityStudent> student = universityStudentService.findById(id);
        if (student.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("STUDENT FOUND");
    }


    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody UniversityStudent universityStudent) {
        UniversityStudent newStudent = universityStudentService.SaveStudent(universityStudent);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(universityStudent.getId())
                .toUri();
        return ResponseEntity.created(location).body("ADD STUDENT SUCCESS");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        Optional<UniversityStudent> CurrentStudent = universityStudentService.findById(id);
        if (CurrentStudent.isPresent()) {
            universityStudentService.DeleteStudent(CurrentStudent.get());
            return ResponseEntity.ok("DELETE STUDENT SUCCESS");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DELETE FAILED - student not found");

    }
}