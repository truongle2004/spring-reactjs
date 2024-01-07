package com.example.demo.Exception;

import com.example.demo.modelStudent.UniversityStudent;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class UniversityStudentNotFoundException extends RuntimeException {
    public UniversityStudentNotFoundException(long id) {
        super("could not find student" + id);
    }
}
