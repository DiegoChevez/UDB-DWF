package sv.edu.udb.demo_jsf.repository;

import jakarta.enterprise.context.ApplicationScoped;
import sv.edu.udb.demo_jsf.repository.model.Student;

import java.util.List;


@ApplicationScoped
public class StudentRepository {

    public List<Student> findAll() {
        return List.of(
                new Student(1L, "Juan", "Perez", "juan.perez@udb.edu.svs"),
                new Student(2L, "Maria", "Cruz", "maria.cruz@udb.edu.svs"),
                new Student(3L, "Julia", "Jimenez", "julia.jimenez@udb.edu.svs"),
                new Student(4L, "Sofia", "Lopez", "sofia.lopez@udb.edu.svs"),
                new Student(5L, "Jorge", "Vasquez", "jorge.vasquez@udb.edu.svs"));
    }

}
