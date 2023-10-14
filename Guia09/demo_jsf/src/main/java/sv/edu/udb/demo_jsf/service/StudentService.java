package sv.edu.udb.demo_jsf.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import sv.edu.udb.demo_jsf.repository.StudentRepository;
import sv.edu.udb.demo_jsf.repository.model.Student;

import java.util.List;

@ApplicationScoped
public class StudentService {

    @Inject
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
