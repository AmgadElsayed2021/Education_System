package com.example.educationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/program")
public class ProgramsController {
    @Autowired
    private ProgramsRepo PR;

    @Autowired
    private CourseRepo CR;

    @Autowired
    private EnrollmentRepo ER;

    @Autowired
    private GradesRepo GR;

    //    add a Program
    @PostMapping(path = "/add")
    public @ResponseBody
    String addProgram (@RequestParam String programName, @RequestParam String campus){
        Programs pr =new Programs();
        pr.setProgramName(programName);
        pr.setCampus(campus);
        PR.save(pr);
        return "Saved";
    }

    //api that uses json to add a new object
    //needs to be tested
    //    passed testing
    @PostMapping(path="/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addAProgram (@RequestBody Programs p){
        PR.save(p);
        return "Saved";
    }


    //needs to be tested
    //    passed testing
    @GetMapping(path="/list")
    public @ResponseBody Iterable<Programs> getAllPrograms() {
        return PR.findAll();
    }


    //needs to be tested
    //    passed testing
    @GetMapping(path="/view/{pid}")
    public @ResponseBody
    Optional<Programs> getProgramById(@PathVariable int pid) {
        return PR.findById(pid);
    }


    //needs to be tested
    //    passed testing
    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deleteProgram(@PathVariable Integer id){
        List <Course> courses=CR.findAllByPid(id);
        for (Course course:courses){
            List<Enrollment> enrollments=ER.findAllByCourseId(course.getCourseId());
            ER.deleteAll(enrollments);

            //delete the record from grades table
            List<Grades> grades=GR.findAllByCourseId(course.getCourseId());
            GR.deleteAll(grades);

        CR.delete(course);
        }

        PR.deleteById(id);

        return "Deleted.";}


    //needs to be tested
    //    passed testing
    @PutMapping(path="/modify",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String modifyProgram(@RequestBody Programs p){
        Programs program = PR.findProgramByPid(p.getPid());
        program.setProgramName(p.getProgramName());
        program.setCampus(p.getCampus());
        PR.save(program);
        return "Modified";
    }


}
