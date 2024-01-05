package com.example.demo.Service;

import com.example.demo.Reponsitory.RepositoryStudent;
import com.example.demo.modelStudent.UniversityStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UniversityStundentServicelmp implements UniversityStudentService {
    @Override
    public List<UniversityStudent> findAllStudents() {

    }

    @Override
    public void SaveStudents(UniversityStudent universityStudent) {

    }

    @Override
    public void DeleteStudents(UniversityStudent universityStudent) {

    }

    @Override
    public Optional<UniversityStudent> findStudentById(long id) {
        return Optional.empty();
    }
}
