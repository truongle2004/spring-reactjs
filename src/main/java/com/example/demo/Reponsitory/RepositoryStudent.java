package com.example.demo.Reponsitory;

import com.example.demo.modelStudent.UniversityStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Repository annotation help access and interact with database
public interface RepositoryStudent extends JpaRepository<UniversityStudent, Long> {
}
