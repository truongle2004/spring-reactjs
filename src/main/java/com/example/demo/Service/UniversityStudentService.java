package com.example.demo.Service;


import com.example.demo.modelStudent.UniversityStudent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UniversityStudentService {
    public List<UniversityStudent> findAllStudents();
    public UniversityStudent SaveStudent(UniversityStudent universityStudent);
    public void DeleteStudent(UniversityStudent universityStudent);
    public Optional<UniversityStudent> findById(long id);
}
