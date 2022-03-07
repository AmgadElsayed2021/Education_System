package com.example.educationsystem;
import org.springframework.data.repository.CrudRepository;

public interface ProgramsRepo extends CrudRepository<Programs,Integer> {
    Programs findProgramByPid(Integer pid);

    void deleteById(Integer id);
}
