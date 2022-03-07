package com.example.educationsystem;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student ,Integer> {
    Student findStudentByStudentId(Integer studentId);

    void deleteById(Integer id);
}
