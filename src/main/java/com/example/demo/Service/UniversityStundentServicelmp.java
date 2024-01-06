package com.example.demo.Service;

import com.example.demo.Reponsitory.RepositoryStudent;
import com.example.demo.modelStudent.UniversityStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UniversityStundentServicelmp implements UniversityStudentService {

    @Autowired
    private RepositoryStudent repositoryStudent;

    @Override
    public List<UniversityStudent> findAllStudents() {
        return repositoryStudent.findAll();
    }

    @Override
    public UniversityStudent SaveStudent(UniversityStudent universityStudent) {
       return repositoryStudent.save(universityStudent);
    }

    @Override
    public void DeleteStudent(UniversityStudent universityStudent) {
        repositoryStudent.delete(universityStudent);
    }



    @Override
    public Optional<UniversityStudent> findById(long id) {
        return repositoryStudent.findById(id);
    }
}
