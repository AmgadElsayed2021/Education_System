package com.example.educationsystem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GradesRepo extends CrudRepository <Grades,Integer>{
    List<Grades> findAllByCourseId(Integer courseId);
    List<Grades> findAllByStudentId(Integer studentId);

    @Override
    void deleteById(Integer integer);
    void deleteAllByStudentId(Integer integer);
    Grades findGradesByGid(Integer gid);
}
