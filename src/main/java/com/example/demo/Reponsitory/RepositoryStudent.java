package com.example.demo.Reponsitory;

import com.example.demo.modelStudent.UniversityStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryStudent extends JpaRepository<UniversityStudent, Integer> {
}
