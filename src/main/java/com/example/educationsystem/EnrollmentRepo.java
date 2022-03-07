package com.example.educationsystem;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface EnrollmentRepo extends CrudRepository<Enrollment,Integer> {
    List<Enrollment> findAllByStudentId(Integer studentId);
    List<Enrollment> findAllByCourseId(Integer courseId);

    @Override
    void deleteById(Integer integer);
    Enrollment findEnrollmentByEid(Integer eid);
}
