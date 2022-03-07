package com.example.educationsystem;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.List;

public interface CourseRepo extends CrudRepository<Course ,Integer> {


    Course findCourseByCourseId(Integer courseId);
    List <Course> findAllByPid(Integer Pid);

    @Override
    void deleteById(Integer id);
}
